package space.chensheng.wechatty.common.message.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class EmptyInboundMessage extends InboundMessage {
	
	@XStreamAlias("Event")
	@XStreamCDATA
	protected EventType event;
	
	public EmptyInboundMessage(MessageType msgType) {
		super(msgType);
	}

	public EventType getEvent() {
		return event;
	}

	public void setEvent(EventType event) {
		this.event = event;
	}

}
