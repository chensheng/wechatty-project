package space.chensheng.wechatty.common.conf;

import space.chensheng.wechatty.common.http.AccessTokenFetcher;
import space.chensheng.wechatty.common.http.PoolingHttpUtil;
import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.material.MultiPartUploader;
import space.chensheng.wechatty.common.material.StringBodyUploader;
import space.chensheng.wechatty.common.security.WXBizMsgCrypt;
import space.chensheng.wechatty.common.security.WechatCallbackModeVerifier;
import space.chensheng.wechatty.common.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class AppContext {
	private ThreadLocal<String> currentWechatContextId = new ThreadLocal<String>();

	private WechatContext defaultWechatContext;

	private List<WechatContext> wechatContexts = new ArrayList<WechatContext>();
	
	private WXBizMsgCrypt wxBizMsgCrypt;
	
	private WechatCallbackModeVerifier callbackModeVerifier;
	
	private AccessTokenFetcher accessTokenFetcher;
	
	private WechatRequester wechatRequester;
	
	private MultiPartUploader multiPartUploader;
	
	private StringBodyUploader stringBodyUploader;
	
	private PoolingHttpUtil poolingHttpUtil;

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

	public PoolingHttpUtil getPoolingHttpUtil() {
		return poolingHttpUtil;
	}

	public void setPoolingHttpUtil(PoolingHttpUtil poolingHttpUtil) {
		this.poolingHttpUtil = poolingHttpUtil;
	}

	public void switchWechatContext(String contextId) {
		currentWechatContextId.set(contextId);
	}

	public void addWechatContext(WechatContext wechatContext) {
		if(wechatContext == null) {
			return;
		}

		if(this.defaultWechatContext == null) {
			this.defaultWechatContext = wechatContext;
		}
		wechatContexts.add(wechatContext);
	}

	public void setWechatContext(WechatContext wechatContext) {
		this.addWechatContext(wechatContext);
	}

	public WechatContext getWechatContext() {
		String contextId = currentWechatContextId.get();
		if(StringUtil.isEmpty(contextId) || wechatContexts.size() == 0) {
			return defaultWechatContext;
		}

		for(WechatContext wechatContext : wechatContexts) {
			if(contextId.equals(wechatContext.getContextId())) {
				return wechatContext;
			}
		}
		return defaultWechatContext;
	}

	public List<WechatContext> getWechatContexts() {
		return wechatContexts;
	}
}
