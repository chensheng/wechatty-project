package space.chensheng.wechatty.common.http;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.util.StringUtil;

public class PoolingHttpClient {
	private WechatContext wechatContext;
	
	private CloseableHttpClient httpClient;
	
	public PoolingHttpClient(AppContext appContext) {
		this.wechatContext = appContext.getWechatContext();
		
		PoolingHttpClientConnectionManager poolingConnMgr = null;
		Registry<ConnectionSocketFactory> registry = null;
		if (appContext.getHttpClientCustomizer() != null) {
			registry = appContext.getHttpClientCustomizer().createRegistry(appContext);
		}
		if (registry == null) {
			poolingConnMgr = new PoolingHttpClientConnectionManager();
		} else {
			poolingConnMgr = new PoolingHttpClientConnectionManager(registry);
		}
		
		poolingConnMgr.setDefaultMaxPerRoute(wechatContext.getPoolingHttpMaxPerRoute());
		poolingConnMgr.setMaxTotal(wechatContext.getPoolingHttpMaxTotal());
		SocketConfig socketConfig = SocketConfig.custom()
				.setSoTimeout(wechatContext.getPoolingHttpSocketTimeoutMillis())
				.setTcpNoDelay(wechatContext.isPoolingHttpTcpNoDelay())
				.build();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(wechatContext.getPoolingHttpSocketTimeoutMillis())
				.setConnectTimeout(wechatContext.getPoolingHttpConnectTimeoutMillis())
				.setConnectionRequestTimeout(wechatContext.getPoolingHttpConnectionRequestTimeoutMillis())
				.build();
		poolingConnMgr.setDefaultSocketConfig(socketConfig);
		
		HttpClientBuilder httpClientBuilder = HttpClients.custom()
				.setDefaultSocketConfig(socketConfig)
				.setDefaultRequestConfig(requestConfig)
				.setConnectionManager(poolingConnMgr);
		if (wechatContext.isPoolingHttpProxyEnable()) {
			HttpHost proxy = new HttpHost(wechatContext.getPoolingHttpProxyHostname(), wechatContext.getPoolingHttpProxyPort());
			httpClientBuilder.setProxy(proxy);
			
			if (StringUtil.isNotEmpty(wechatContext.getPoolingHttpProxyUsername()) && StringUtil.isNotEmpty(wechatContext.getPoolingHttpProxyPassword())) {
				CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
				AuthScope authScope = new AuthScope(wechatContext.getPoolingHttpProxyHostname(), wechatContext.getPoolingHttpProxyPort());
				Credentials credentials = new UsernamePasswordCredentials(wechatContext.getPoolingHttpProxyUsername(), wechatContext.getPoolingHttpProxyPassword());
				credentialsProvider.setCredentials(authScope, credentials);
				httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
			}
		}
		
		if (appContext.getHttpClientCustomizer() != null) {
			appContext.getHttpClientCustomizer().customize(httpClientBuilder, appContext);
		}
		
		httpClient = httpClientBuilder.build();
	}
	
	public CloseableHttpClient get() {
		return httpClient;
	}
	
}
