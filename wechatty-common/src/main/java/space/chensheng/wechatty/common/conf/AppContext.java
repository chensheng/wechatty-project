package space.chensheng.wechatty.common.conf;

import space.chensheng.wechatty.common.http.AccessTokenFetcher;
import space.chensheng.wechatty.common.http.HttpClientCustomizer;
import space.chensheng.wechatty.common.http.PoolingHttpUtil;
import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.material.MultiPartUploader;
import space.chensheng.wechatty.common.material.StringBodyUploader;
import space.chensheng.wechatty.common.security.WXBizMsgCrypt;
import space.chensheng.wechatty.common.security.WechatCallbackModeVerifier;

public class AppContext {
	private WechatContext wechatContext;
	
	private WXBizMsgCrypt wxBizMsgCrypt;
	
	private WechatCallbackModeVerifier callbackModeVerifier;
	
	private AccessTokenFetcher accessTokenFetcher;
	
	private WechatRequester wechatRequester;
	
	private MultiPartUploader multiPartUploader;
	
	private StringBodyUploader stringBodyUploader;
	
	private HttpClientCustomizer httpClientCustomizer;
	
	private PoolingHttpUtil poolingHttpUtil;

	public WechatContext getWechatContext() {
		return wechatContext;
	}

	public void setWechatContext(WechatContext wechatContext) {
		this.wechatContext = wechatContext;
	}

	public WXBizMsgCrypt getWxBizMsgCrypt() {
		return wxBizMsgCrypt;
	}

	public void setWxBizMsgCrypt(WXBizMsgCrypt wxBizMsgCrypt) {
		this.wxBizMsgCrypt = wxBizMsgCrypt;
	}

	public WechatCallbackModeVerifier getCallbackModeVerifier() {
		return callbackModeVerifier;
	}

	public void setCallbackModeVerifier(WechatCallbackModeVerifier callbackModeVerifier) {
		this.callbackModeVerifier = callbackModeVerifier;
	}

	public AccessTokenFetcher getAccessTokenFetcher() {
		return accessTokenFetcher;
	}

	public void setAccessTokenFetcher(AccessTokenFetcher accessTokenFetcher) {
		this.accessTokenFetcher = accessTokenFetcher;
	}

	public WechatRequester getWechatRequester() {
		return wechatRequester;
	}

	public void setWechatRequester(WechatRequester wechatRequester) {
		this.wechatRequester = wechatRequester;
	}

	public MultiPartUploader getMultiPartUploader() {
		return multiPartUploader;
	}

	public void setMultiPartUploader(MultiPartUploader multiPartUploader) {
		this.multiPartUploader = multiPartUploader;
	}

	public StringBodyUploader getStringBodyUploader() {
		return stringBodyUploader;
	}

	public void setStringBodyUploader(StringBodyUploader stringBodyUploader) {
		this.stringBodyUploader = stringBodyUploader;
	}

	public HttpClientCustomizer getHttpClientCustomizer() {
		return httpClientCustomizer;
	}

	public void setHttpClientCustomizer(HttpClientCustomizer httpClientCustomizer) {
		this.httpClientCustomizer = httpClientCustomizer;
	}

	public PoolingHttpUtil getPoolingHttpUtil() {
		return poolingHttpUtil;
	}

	public void setPoolingHttpUtil(PoolingHttpUtil poolingHttpUtil) {
		this.poolingHttpUtil = poolingHttpUtil;
	}

}
