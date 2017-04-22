package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;


public class LocationInboundMessage extends SimpleInboundMessage {

	@XStreamAlias("Location_X")
	private String locationX;
	
	@XStreamAlias("Location_Y")
	private String locationY;
	
	@XStreamAlias("Scale")
	private Integer scale;
	
	@XStreamAlias("Label")
    @XStreamCDATA
	private String label;
	
	public LocationInboundMessage() {
		super(MessageType.LOCATION);
	}

	public String getLocationX() {
		return locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public Integer getScale() {
		return scale;
	}

	public String getLabel() {
		return label;
	}

}
