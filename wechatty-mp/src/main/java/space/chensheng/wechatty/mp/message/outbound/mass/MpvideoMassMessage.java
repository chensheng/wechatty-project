package space.chensheng.wechatty.mp.message.outbound.mass;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;

public class MpvideoMassMessage extends MassOutboundMessage {
	@JsonProperty
	private Mpvideo mpvideo;
	
	public MpvideoMassMessage() {
		super(MessageType.MPVIDEO);
		mpvideo = new Mpvideo();
	}
	
	public void setMediaId(String mediaId) {
		mpvideo.mediaId = mediaId;
	}
	
	private static class Mpvideo {
		@JsonProperty("media_id")
		private String mediaId;
	}

}
