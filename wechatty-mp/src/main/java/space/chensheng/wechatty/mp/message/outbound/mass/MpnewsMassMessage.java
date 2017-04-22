package space.chensheng.wechatty.mp.message.outbound.mass;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;

public class MpnewsMassMessage extends MassOutboundMessage {
	
	@JsonProperty
	private Mpnews mpnews;
	
	@JsonProperty
	private int sendIgnoreReprint;
	
	public MpnewsMassMessage() {
		super(MessageType.MPNEWS);
		mpnews = new Mpnews();
	}
	
	public void setMediaId(String mediaId) {
		mpnews.mediaId = mediaId;
	}
	
	public void sendIgnoreReprint() {
		sendIgnoreReprint = 1;
	}
	
	public void sendDropReprint() {
		sendIgnoreReprint = 0;
	}

	private static class Mpnews {
		@JsonProperty("media_id")
		private String mediaId;
	}
}
