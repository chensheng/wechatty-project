package space.chensheng.wechatty.common.message.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public abstract class ReplyMessage extends XmlMessage {
	
	@XStreamAlias("ToUserName")
	@XStreamCDATA
	protected String toUserName;
	
	@XStreamAlias("FromUserName")
	@XStreamCDATA
	protected String fromUserName;
	
	@XStreamAlias("CreateTime")
	protected Long createTime;
	
	@XStreamAlias("MsgType")
	@XStreamCDATA
	protected MessageType msgType;
	
	public ReplyMessage(MessageType msgType) {
		this.msgType = msgType;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public MessageType getMsgType() {
		return msgType;
	}

}
