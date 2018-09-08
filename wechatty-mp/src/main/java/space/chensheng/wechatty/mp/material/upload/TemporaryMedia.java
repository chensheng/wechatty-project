package space.chensheng.wechatty.mp.material.upload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.Material;
import space.chensheng.wechatty.common.material.MaterialUploader;
import space.chensheng.wechatty.common.material.MediaType;

public abstract class TemporaryMedia extends Material {

	private MediaType mediaType;
	
	private File media;
	
	/**
	 * The material will expire in 3 days 
	 * @param mediaType
	 * @param media
	 * @throws NullPointerException if any argument is null
	 */
	public TemporaryMedia(AppContext appContext, MediaType mediaType, File media) {
		super(appContext, "https://api.weixin.qq.com/cgi-bin/media/upload");
		
		if (mediaType == null) {
			throw new NullPointerException("mediaType may not be null");
		}
		
		if (media == null) {
			throw new NullPointerException("media may not be null");
		}
		
		this.mediaType = mediaType;
		this.media = media;
	}

	@Override
	protected void addQueryParam(Map<String, String> queryParams) {
		queryParams.put("access_token", this.getAppContext().getAccessTokenFetcher().getAccessToken());
		queryParams.put("type", mediaType.toString());
	}
	
	@Override
	protected Object createPostBody() {
		Map<String, Object> postBody = new HashMap<String, Object>();
		postBody.put("media", media);
		return postBody;
	}
	
	@Override
	protected MaterialUploader getUploader(AppContext appContext) {
		return appContext.getMultiPartUploader();
	}
}
