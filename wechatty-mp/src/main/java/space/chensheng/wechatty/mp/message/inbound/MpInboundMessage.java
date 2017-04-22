package space.chensheng.wechatty.mp.message.inbound;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.InboundMessage;

public abstract class MpInboundMessage extends InboundMessage {

	public MpInboundMessage(MessageType msgType) {
		super(msgType);
	}
	
}
