package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class ImageCsMessage extends CsOutboundMessage {
	@JsonProperty
	private Image image;
	
	public ImageCsMessage() {
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
