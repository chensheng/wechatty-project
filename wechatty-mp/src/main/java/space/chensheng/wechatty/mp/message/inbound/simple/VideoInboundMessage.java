package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;

public class VideoInboundMessage extends SimpleInboundMessage {
	
	@XStreamAlias("MediaId")
    @XStreamCDATA
	private String mediaId;
	
	@XStreamAlias("ThumbMediaId")
    @XStreamCDATA
	private String thumdMediaId;
	
	public VideoInboundMessage() {
		super(MessageType.VIDEO);
	}

	public String getThumdMediaId() {
		return thumdMediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

}
