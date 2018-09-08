package space.chensheng.wechatty.common.message;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.message.base.OutboundMessage;
import space.chensheng.wechatty.common.util.StringUtil;

public abstract class MessageSender {
	private AppContext appContext;

	/**
	 * 
	 * @param appContext application context
	 */
	public MessageSender(AppContext appContext) {
		this.appContext = appContext;
	}
	
	
	/**
	 * send message with retry when fail to send message
	 * @param sendUrl URL of sending message
	 * @param message message to send
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
	 * @param sendUrl URL of sending message, not include "?access_token=xxx"
	 * @param message message to send
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
		
		String formattedSendUrl = String.format("%s?access_token=%s", sendUrl, appContext.getAccessTokenFetcher().getAccessToken());
		return appContext.getWechatRequester().postString(formattedSendUrl, message.toString(), SendMessageResponse.class);
	}
}
