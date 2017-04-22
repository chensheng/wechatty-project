package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;

public class ImageInboundMessage extends SimpleInboundMessage {

	@XStreamAlias("PicUrl")
	@XStreamCDATA
	private String picUrl;
	
	@XStreamAlias("MediaId")
	@XStreamCDATA
	private String mediaId;
	
	public ImageInboundMessage() {
		super(MessageType.IMAGE);
	}

	public String getPicUrl() {
		return picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}
	
}
