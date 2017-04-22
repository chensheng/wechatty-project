package space.chensheng.wechatty.mp.message.outbound;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.OutboundMessage;

public abstract class MpOutboundMessage extends OutboundMessage {

	public MpOutboundMessage(MessageType msgType) {
		super(msgType);
	}
	
}
