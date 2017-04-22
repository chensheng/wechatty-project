package space.chensheng.wechatty.mp.message.inbound.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.EventInboundMessage;

public class SubscribeEventMessage extends EventInboundMessage {

	@XStreamAlias("EventKey")
	@XStreamCDATA
	private String eventKey;
	
	public SubscribeEventMessage() {
		super(EventType.SUBSCRIBE);
	}

	/**
	 * 
	 * @return qrscene_xxx
	 */
	public String getEventKey() {
		return eventKey;
	}

}
