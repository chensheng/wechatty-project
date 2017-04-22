package space.chensheng.wechatty.mp.message;

import space.chensheng.wechatty.common.message.MessageSender;
import space.chensheng.wechatty.common.message.SendMessageResponse;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;
import space.chensheng.wechatty.mp.util.MpAccessTokenFetcher;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class MpMessageSender extends MessageSender {
	
	private static class InstanceHolder {
		public static MpMessageSender instance = new MpMessageSender();
	}
	
	public static MpMessageSender getInstance() {
		return InstanceHolder.instance;
	}
	
	
	private MpMessageSender() {
		super(MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}

	/**
	 * send customer service message without retry
	 * @param message
	 * @return
	 * @throws NullPointerException if message is null
	 */
	public SendMessageResponse send(CsOutboundMessage message) {
		return send(message, 0);
	}
	
	/**
	 * send customer service message with retry
	 * @param message
	 * @param retry
	 * @return
	 * @throws NullPointerException if message is null
	 */
	public SendMessageResponse send(CsOutboundMessage message, int retry) {
		return doSendMessageWithRetry("https://api.weixin.qq.com/cgi-bin/message/custom/send", message, retry);
	}
	
	/**
	 * send mass message without retry
	 * @param message
	 * @return
	 * @throws NullPointerException if message is null
	 */
	public SendMessageResponse send(MassOutboundMessage message) {
		return send(message, 0);
	}
	
	/**
	 * send mass message with retry
	 * @param message
	 * @param retry
	 * @return NullPointerException if message is null
	 */
	public SendMessageResponse send(MassOutboundMessage message, int retry) {
		if (message == null) {
			throw new NullPointerException("message may not be null");
		}
		
		if (message.isToUser()) {
			return doSendMessageWithRetry("https://api.weixin.qq.com/cgi-bin/message/mass/send", message, retry);
		}
		
		return doSendMessageWithRetry("https://api.weixin.qq.com/cgi-bin/message/mass/sendall", message, retry);
	}
}
