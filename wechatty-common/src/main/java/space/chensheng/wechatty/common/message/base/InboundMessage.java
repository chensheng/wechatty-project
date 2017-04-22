package space.chensheng.wechatty.common.message.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public abstract class InboundMessage extends XmlMessage {

	@XStreamAlias("ToUserName")
	@XStreamCDATA
	private String toUserName;
	
	@XStreamAlias("FromUserName")
	@XStreamCDATA
	private String fromUserName;
	
	@XStreamAlias("CreateTime")
	private Long createTime;
	
	@XStreamAlias("MsgType")
	@XStreamCDATA
	private MessageType msgType;
	
	public InboundMessage(MessageType msgType) {
		this.msgType = msgType;
	}

	public String getToUserName() {
		return toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public MessageType getMsgType() {
		return msgType;
	}
}
