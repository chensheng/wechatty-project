package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class VideoCsMessage extends CsOutboundMessage {
	
	@JsonProperty
	private Video video;
	
	public VideoCsMessage() {
		super(MessageType.VIDEO);
		video = new Video();
	}
	
	public void setVideo(String title, String description, String mediaId, String thumbMediaId) {
		video.title = title;
		video.description = description;
		video.mediaId = mediaId;
		video.thumbMediaId = thumbMediaId;
	}

	private static class Video {
		@JsonProperty("media_id")
		private String mediaId;
		
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		
		@JsonProperty
		private String title;
		
		@JsonProperty
		private String description;
	}
}
