package space.chensheng.wechatty.mp.message.outbound;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;

public abstract class MassOutboundMessage extends MpOutboundMessage {
	
	@JsonProperty
	private Filter filter;
	
	@JsonProperty("touser")
	private List<String> toUser;
	
	public MassOutboundMessage(MessageType msgType) {
		super(msgType);
		filter = new Filter();
		toUser = new ArrayList<String>();
	}
	
	/**
	 * Whether to send message to all users
	 * @param isToAll true if send to all user
	 */
	public void setIsToAll(Boolean isToAll) {
		filter.isToAll = isToAll;
	}
	
	/**
	 * Send message to users by tag id, and {@code this#setIsToAll(false)} should be called
	 * @param tagId 
	 */
	public void setTagId(String tagId) {
		filter.tagId = tagId;
	}
	
	public void addToUser(String openId) {
		toUser.add(openId);
	}
	
	/**
	 * 
	 * @return true if sending message to users by OPENID
	 */
	public boolean isToUser() {
		return !toUser.isEmpty();
	}

	private class Filter {
		@JsonProperty("is_to_all")
		private Boolean isToAll;
		
		@JsonProperty("tag_id")
		private String tagId;		
	}
}
