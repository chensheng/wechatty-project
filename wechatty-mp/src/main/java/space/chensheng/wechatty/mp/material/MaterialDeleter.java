package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.util.JsonBean;

public class MaterialDeleter {
	private AppContext appContext;
	
	public MaterialDeleter(AppContext appContext) {
		this.appContext = appContext;
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public DeleteResponse delete(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		
		DeletePostData postData = new DeletePostData(mediaId);
		return appContext.getWechatRequester().postString(url, postData.toString(), DeleteResponse.class);
	}
	
	private static class DeletePostData extends JsonBean {
		@JsonProperty("media_id")
		String mediaId;
		
		DeletePostData(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
