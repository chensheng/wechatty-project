package space.chensheng.wechatty.mp.message.inbound;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;

public abstract class SimpleInboundMessage extends MpInboundMessage {
	
	@XStreamAlias("MsgId")
	private String msgId;

	public SimpleInboundMessage(MessageType msgType) {
		super(msgType);
	}

	public String getMsgId() {
		return msgId;
	}

}
