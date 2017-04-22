package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class MpnewsCsMessage extends CsOutboundMessage {
	
	@JsonProperty
	private Mpnews mpnews;
	
	public MpnewsCsMessage() {
		super(MessageType.MPNEWS);
		mpnews = new Mpnews();
	}
	
	public void setMediaId(String mediaId) {
		mpnews.mediaId = mediaId;
	}

	private static class Mpnews {
		@JsonProperty("media_id")
		private String mediaId;
	}
}
