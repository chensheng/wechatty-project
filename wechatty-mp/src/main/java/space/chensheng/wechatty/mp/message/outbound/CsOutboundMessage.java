package space.chensheng.wechatty.mp.message.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;

/**
 * customer service outbound message
 * @author sheng.chen
 */
public abstract class CsOutboundMessage extends MpOutboundMessage {

	@JsonProperty("touser")
	private String toUser;
	
	public CsOutboundMessage(MessageType msgType) {
		super(msgType);
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

}
