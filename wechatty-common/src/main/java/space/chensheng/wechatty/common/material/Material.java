package space.chensheng.wechatty.common.material;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import space.chensheng.wechatty.common.conf.AppContext;

public abstract class Material {
	private AppContext appContext;
	
	private String uploadUrl;
	
	private Map<String, String> queryParams;
	
	/**
	 * 
	 * @param appContext application context
	 * @param uploadUrl material upload URL
	 * @throws NullPointerException if any argument is null
	 */
	public Material(AppContext appContext, String uploadUrl) {
		if (appContext == null) {
			throw new NullPointerException("appContext may not be null");
		}
		
		if (uploadUrl == null) {
			throw new NullPointerException("uploadUrl may not be null");
		}
		
		this.appContext = appContext;
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
		queryParams.put("access_token", appContext.getAccessTokenFetcher().getAccessToken());
		this.addQueryParam(queryParams);
		return this.getUploader(appContext).upload(this);
	}
	
	protected abstract MaterialUploader getUploader(AppContext appContext);
	
	public AppContext getAppContext() {
		return appContext;
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
