package space.chensheng.wechatty.mp.message.outbound.mass;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;

public class VoiceMassMessage extends MassOutboundMessage {
	@JsonProperty
	private Voice voice;
	
	public VoiceMassMessage() {
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
