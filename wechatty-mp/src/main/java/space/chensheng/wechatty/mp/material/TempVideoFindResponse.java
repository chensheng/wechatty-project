package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;

public class TempVideoFindResponse extends BaseResponse {
	private static final long serialVersionUID = -8072017916517841604L;
	
	@JsonProperty("video_url")
	String videoUrl;

	public String getVideoUrl() {
		return videoUrl;
	}
}
