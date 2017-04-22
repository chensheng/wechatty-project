package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.util.JsonBean;
import space.chensheng.wechatty.mp.util.MpAccessTokenFetcher;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class MaterialDeleter {
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public static DeleteResponse delete(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=%s", MpAccessTokenFetcher.getInstance().getAccessToken());
		
		DeletePostData postData = new DeletePostData(mediaId);
		return WechatRequester.postString(url, postData.toString(), DeleteResponse.class, MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}
	
	private static class DeletePostData extends JsonBean {
		@JsonProperty("media_id")
		String mediaId;
		
		DeletePostData(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
