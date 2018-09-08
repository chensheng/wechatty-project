package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.http.BaseResponse;
import space.chensheng.wechatty.common.material.MediaType;
import space.chensheng.wechatty.common.util.JsonBean;

public class MaterialQuery {
	private AppContext appContext;
	
	public MaterialQuery(AppContext appContext) {
		this.appContext = appContext;
	}
	
	/**
	 * 
	 * @return null if network error
	 */
	public CountQueryResponse count() {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		return appContext.getWechatRequester().postString(url, null, CountQueryResponse.class);
	}
	
	/**
	 * 
	 * @param offset {@code >= 0}
	 * @param count {@code >= 1 && <= 20}
	 * @return null if network error
	 */
	public NewsListResponse listNews(int offset, int count) {
		ListPostData postData = new ListPostData(MediaType.NEWS, offset, count);
		return list(postData, NewsListResponse.class);
	}
	
	/**
	 * 
	 * @param mediaType
	 * @param offset {@code >= 0}
	 * @param count {@code >= 1 && <= 20}
	 * @return null if network error
	 * @throws NullPointerException if mediaType is null
	 * @throws IllegalArgumentException if mediaType is {@link MediaType#NEWS}
	 */
	public MediaListResponse listMedia(MediaType mediaType, int offset, int count) {
		if (mediaType == null) {
			throw new NullPointerException("mediaType may not be null");
		}
		
		if (mediaType == MediaType.NEWS) {
			throw new IllegalArgumentException("mediaType news is not supported");
		}
		
		ListPostData postData = new ListPostData(mediaType, offset, count);
		return list(postData, MediaListResponse.class);
	}
	
	private <T extends BaseResponse> T list(ListPostData postData, Class<T> retClzz) {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		return appContext.getWechatRequester().postString(url, postData.toString(), retClzz);
	}
	
	private static class ListPostData extends JsonBean {
		@JsonProperty
		MediaType type;
		
		@JsonProperty
		int offset;
		
		@JsonProperty
		int count;
		
		ListPostData(MediaType type, int offset, int count) {
			if (offset < 0) {
				offset = 0;
			}
			
			if (count < 1) {
				count = 1;
			} else if (count > 20) {
				count = 20;
			}
			
			this.type = type;
			this.offset = offset;
			this.count = count;
		}
	}
}
