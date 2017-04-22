package space.chensheng.wechatty.mp.message.inbound.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.mp.message.inbound.EventInboundMessage;

public class LocationEventMessage extends EventInboundMessage {

	@XStreamAlias("Latitude")
	private String latitude;
	
	@XStreamAlias("Longitude")
	private String longitude;
	
	@XStreamAlias("Precision")
	private String precision;
	
	public LocationEventMessage() {
		super(EventType.LOCATION);
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getPrecision() {
		return precision;
	}

}
