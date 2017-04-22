package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;

public class CountQueryResponse extends BaseResponse {
	@JsonProperty("voice_count")
	private Integer voiceCount;
	
	@JsonProperty("video_count")
	private Integer videoCount;
	
	@JsonProperty("image_count")
	private Integer imageCount;
	
	@JsonProperty("news_count")
	private Integer newsCount;

	public Integer getVoiceCount() {
		return voiceCount;
	}

	public Integer getVideoCount() {
		return videoCount;
	}

	public Integer getImageCount() {
		return imageCount;
	}

	public Integer getNewsCount() {
		return newsCount;
	}
}
