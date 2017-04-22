package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;

public class VoiceInboundMessage extends SimpleInboundMessage {
	
	@XStreamAlias("MediaId")
    @XStreamCDATA
	private String mediaId;
	
    @XStreamAlias("Format")
    @XStreamCDATA
	private String format;
    
    @XStreamAlias("Recognition")
	@XStreamCDATA
	private String recognition;
	
	public VoiceInboundMessage() {
		super(MessageType.VOICE);
	}

	public String getMediaId() {
		return mediaId;
	}

	public String getFormat() {
		return format;
	}
	
	public String getRecognition() {
		return recognition;
	}

}
