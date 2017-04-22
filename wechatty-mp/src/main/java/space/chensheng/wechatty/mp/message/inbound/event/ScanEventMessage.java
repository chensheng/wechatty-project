package space.chensheng.wechatty.mp.message.inbound.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.EventInboundMessage;

public class ScanEventMessage extends EventInboundMessage {
	
	@XStreamAlias("EventKey")
	@XStreamCDATA
	private String eventKey;
	
	@XStreamAlias("Ticket")
	@XStreamCDATA
	private String ticket;
	
	public ScanEventMessage() {
		super(EventType.SCAN);
	}

	public String getEventKey() {
		return eventKey;
	}

	public String getTicket() {
		return ticket;
	}

}
