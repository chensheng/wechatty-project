package space.chensheng.wechatty.mp.message.inbound;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public abstract class EventInboundMessage extends MpInboundMessage {

	@XStreamAlias("Event")
	@XStreamCDATA
	private EventType event;
	
	public EventInboundMessage(EventType event) {
		super(MessageType.EVENT);
		this.event = event;
	}

	public EventType getEvent() {
		return event;
	}
}
