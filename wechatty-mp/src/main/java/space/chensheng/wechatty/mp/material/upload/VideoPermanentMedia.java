package space.chensheng.wechatty.mp.material.upload;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.material.MediaType;
import space.chensheng.wechatty.common.util.JsonBean;

public class VideoPermanentMedia extends PermanentMedia {

	private Description description;
	
	/**
	 * 
	 * @param media {@code size <= 10M},  format: mp4
	 * @param title
	 * @param introduction
	 */
	public VideoPermanentMedia(File media, String title, String introduction) {
		super(MediaType.VIDEO, media);
		description = new Description();
		description.title = title;
		description.introduction = introduction;
	}

	@Override
	protected void addPostBody(Map<String, Object> postBody) {
		postBody.put("description", description);
	}
	
	private static class Description extends JsonBean {
		@JsonProperty
		String title;
		
		@JsonProperty
		String introduction;
	}
}
