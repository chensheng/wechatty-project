package space.chensheng.wechatty.mp.message.outbound.mass;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;

public class ImageMassMessage extends MassOutboundMessage {
	@JsonProperty
	private Image image;
	
	public ImageMassMessage() {
		super(MessageType.IMAGE);
		image = new Image();
	}
	
	public void setMediaId(String mediaId) {
		image.mediaId = mediaId;
	}
	
	private static class Image {
		@JsonProperty("media_id")
		private String mediaId;
	}

}
