package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class VoiceCsMessage extends CsOutboundMessage {
	@JsonProperty
	private Voice voice;
	
	public VoiceCsMessage() {
		super(MessageType.VOICE);
		voice = new Voice();
	}
	
	public void setMediaId(String mediaId) {
		voice.mediaId = mediaId;
	}
	
	private static class Voice {
		@JsonProperty("media_id")
		private String mediaId;
	}

}
