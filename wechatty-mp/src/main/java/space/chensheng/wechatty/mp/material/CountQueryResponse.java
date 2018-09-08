package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;

public class CountQueryResponse extends BaseResponse {
	private static final long serialVersionUID = -7750120952322839193L;

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
