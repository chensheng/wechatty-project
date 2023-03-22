package space.chensheng.wechatty.mp.pay;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.http.HttpClientCustomizer;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.mp.util.MpWechatContext;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class PayCertHttpCustomizer implements HttpClientCustomizer {
	private static final Logger logger = LoggerFactory.getLogger(PayCertHttpCustomizer.class);
    	
	public void customize(HttpClientBuilder builder, WechatContext context) {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Registry<ConnectionSocketFactory> createRegistry(WechatContext context) {
		MpWechatContext wechatContext = (MpWechatContext) context;
		String certFile = wechatContext.getPayCertFile();
		String certPassword = wechatContext.getPayCertPassword();
		if (certFile == null) {
			throw new IllegalArgumentException("payCertFile must not be null");
		}
		if (certPassword == null) {
			throw new IllegalArgumentException("payCertPassword must not be null");
		}
		
		FileInputStream certFileIs = null;
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			certFileIs = new FileInputStream(new File(certFile));
			keyStore.load(certFileIs, certPassword.toCharArray());
			
			SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, certPassword.toCharArray()).build();
			ConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1"}, null, new NoopHostnameVerifier());
            ConnectionSocketFactory plainSocketFactory = PlainConnectionSocketFactory.getSocketFactory();
			
			Registry registry = RegistryBuilder
					.create()  
	                .register("http", plainSocketFactory)  
	                .register("https", sslSocketFactory)
	                .build();
			return registry;
		} catch (KeyStoreException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (FileNotFoundException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (NoSuchAlgorithmException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (CertificateException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (KeyManagementException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (UnrecoverableKeyException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} finally {
			if (certFileIs != null) {
				try {
					certFileIs.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
		}
		
		return null;
	}

}
