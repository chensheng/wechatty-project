package space.chensheng.wechatty.common.http;

import org.apache.http.config.Registry;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.conf.WechatContext;

public interface HttpClientCustomizer {
	Registry<ConnectionSocketFactory> createRegistry(WechatContext wechatContext);
	
	void customize(HttpClientBuilder builder, WechatContext wechatContext);
}
