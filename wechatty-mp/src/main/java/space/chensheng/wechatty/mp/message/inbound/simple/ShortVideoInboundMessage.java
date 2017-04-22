package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;


public class ShortVideoInboundMessage extends SimpleInboundMessage{

	@XStreamAlias("MediaId")
    @XStreamCDATA
	private String mediaId;
	
	@XStreamAlias("ThumbMediaId")
    @XStreamCDATA
	private String thumbMediaId;
	
	public ShortVideoInboundMessage() {
		super(MessageType.SHORTVIDEO);
	}

	public String getMediaId() {
		return mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

}
