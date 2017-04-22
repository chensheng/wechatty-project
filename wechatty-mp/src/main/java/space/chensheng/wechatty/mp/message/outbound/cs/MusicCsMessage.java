package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class MusicCsMessage extends CsOutboundMessage {
	
	@JsonProperty
	private Music music;
	
	public MusicCsMessage() {
		super(MessageType.MUSIC);
		music = new Music();
	}
	
	public void setMusic(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
		music.title = title;
		music.description = description;
		music.musicUrl = musicUrl;
		music.hqMusicUrl = hqMusicUrl;
		music.thumbMediaId = thumbMediaId;
	}

	private static class Music {
		@JsonProperty("musicurl")
		private String musicUrl;
		
		@JsonProperty("hqmusicurl")
		private String hqMusicUrl;
		
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		
		@JsonProperty
		private String title;
		
		@JsonProperty
		private String description;
	}
}
