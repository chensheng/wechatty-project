package space.chensheng.wechatty.common.message;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.http.AccessTokenFetcher;
import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.message.base.OutboundMessage;
import space.chensheng.wechatty.common.util.StringUtil;

public abstract class MessageSender {
	private WechatContext wechatContext;
	
	private AccessTokenFetcher accessTokenFetcher;

	/**
	 * 
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @throws NullPointerException if wechatContext or accessTokenFetcher is null
	 */
	public MessageSender(WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher) {
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		this.wechatContext = wechatContext;
		this.accessTokenFetcher = accessTokenFetcher;
	}
	
	
	/**
	 * send message with retry when fail to send message
	 * @param sendUrl
	 * @param message
	 * @param retry retry times, {@code <= 0} means not retry
	 * @return null if fail to send message because of network error
	 */
	protected SendMessageResponse doSendMessageWithRetry(String sendUrl, OutboundMessage message, int retry) {
		SendMessageResponse resp = null;
		if (retry < 0) {
			retry = 0;
		}
		
		resp = this.doSendMessage(sendUrl, message);
		if (resp != null && resp.isOk()) {
			return resp;
		}
		
		if (retry > 0) {
			for (int i = 0; i < retry; i++) {
				resp = this.doSendMessage(sendUrl, message);
				if (resp != null && resp.isOk()) {
					return resp;
				}
			}
		}
		
		return resp;
	}
	
	/**
	 * 
	 * @param sendUrl not include "?access_token=xxx"
	 * @param message
	 * @return null if fail to send message because of network error
	 * @throws NullPointerException if sendUrl or message is null
	 */
	protected SendMessageResponse doSendMessage(String sendUrl, OutboundMessage message) {
		if (StringUtil.isEmpty(sendUrl)) {
			throw new NullPointerException("sendUrl may not be null");
		}
		
		if (message == null) {
			throw new NullPointerException("message may not be null");
		}
		
		String formattedSendUrl = String.format("%s?access_token=%s", sendUrl, accessTokenFetcher.getAccessToken());
		return WechatRequester.postString(formattedSendUrl, message.toString(), SendMessageResponse.class, wechatContext, accessTokenFetcher);
	}
}
