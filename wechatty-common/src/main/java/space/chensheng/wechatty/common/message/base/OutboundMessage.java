package space.chensheng.wechatty.common.message.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;

public abstract class OutboundMessage extends JsonMessage {

	@JsonProperty("msgtype")
	private MessageType msgType;

	public OutboundMessage(MessageType msgType) {
		this.msgType = msgType;
	}

	public MessageType getMsgType() {
		return msgType;
	}
}
