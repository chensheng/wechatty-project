package space.chensheng.wechatty.common.message;

import space.chensheng.wechatty.common.message.base.InboundMessage;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.util.ReflectUtil;

public abstract class MessageListener<T extends InboundMessage> {
	/**
	 * This method should return in 5 seconds, or wechat server will retry to send message.
	 * So don't do time consuming task here.
	 * @param message received message
	 * @return null or concrete {@link ReplyMessage}
	 */
	protected abstract ReplyMessage onMessage(T message);
	
	@SuppressWarnings("unchecked")
	ReplyMessage handleMessage(InboundMessage message) {
		return this.onMessage((T) message);
	}
	
	/**
	 * 
	 * @return type of listening message
	 */
	Class<?> acceptableClass() {
		Class<?> acceptableClass = ReflectUtil.findGenericType(this, MessageListener.class, "T");
		return acceptableClass;
	}
}
