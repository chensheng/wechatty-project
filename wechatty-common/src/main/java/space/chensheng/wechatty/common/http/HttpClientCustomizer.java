package space.chensheng.wechatty.common.http;

import org.apache.http.config.Registry;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;

import space.chensheng.wechatty.common.conf.AppContext;

public interface HttpClientCustomizer {
	Registry<ConnectionSocketFactory> createRegistry(AppContext appContext);
	
	void customize(HttpClientBuilder builder, AppContext appContext);
}
