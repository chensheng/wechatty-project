package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;

public class TextInboundMessage extends SimpleInboundMessage {

	@XStreamAlias("Content")
	@XStreamCDATA
	private String content;
	
	public TextInboundMessage() {
		super(MessageType.TEXT);
	}

	public String getContent() {
		return content;
	}

}
