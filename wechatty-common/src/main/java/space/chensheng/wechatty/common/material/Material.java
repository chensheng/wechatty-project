package space.chensheng.wechatty.common.material;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.http.AccessTokenFetcher;

public abstract class Material {
	private WechatContext wechatContext;
	
	private AccessTokenFetcher accessTokenFetcher;
	
	private MaterialUploader uploader;
	
	private String uploadUrl;
	
	private Map<String, String> queryParams;
	
	/**
	 * 
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @param uploader
	 * @param uploadUrl
	 * @throws NullPointerException if any argument is null
	 */
	public Material(WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher, MaterialUploader uploader, String uploadUrl) {
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		
		if (uploader == null) {
			throw new NullPointerException("uploader may not be null");
		}
		
		if (uploadUrl == null) {
			throw new NullPointerException("uploadUrl may not be null");
		}
		
		this.wechatContext = wechatContext;
		this.accessTokenFetcher = accessTokenFetcher;
		this.uploader = uploader;
		this.uploadUrl = uploadUrl;
		this.queryParams = new HashMap<String, String>();
	}
	
	protected abstract void addQueryParam(final Map<String, String> queryParams);
	
	protected abstract Object createPostBody();
	
	/**
	 * 
	 * @return null if network error
	 */
	public final UploadResponse upload() {
		queryParams.put("access_token", accessTokenFetcher.getAccessToken());
		this.addQueryParam(queryParams);
		return uploader.upload(this);
	}
	
	WechatContext getWechatContext() {
		return wechatContext;
	}
	
	AccessTokenFetcher getAccessTokenFetcher() {
		return accessTokenFetcher;
	}
	
	String getUploadUrl() {
		return uploadUrl;
	}
	
	String generateQuery() {
		StringBuilder result = new StringBuilder();
		Iterator<Entry<String, String>> it = queryParams.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			result.append(entry.getKey());
			result.append("=");
			result.append(entry.getValue());
			if (it.hasNext()) {
				result.append("&");
			}
		}
		return result.toString();
	}
}
