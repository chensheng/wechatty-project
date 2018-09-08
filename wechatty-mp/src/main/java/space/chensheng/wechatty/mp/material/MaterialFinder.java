package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.http.DownloadResponse;
import space.chensheng.wechatty.common.util.JsonBean;

public class MaterialFinder {
	private AppContext appContext;
	
	public MaterialFinder(AppContext appContext) {
		this.appContext = appContext;
	}
	
	/**
	 * 
	 * @param mediaId
	 * @param saveDir
	 * @param fileName a name will be created if null 
	 * @return null if network error
	 * @throws NullPointerException if mediaId or saveDir is null
	 */
	public DownloadResponse downloadPermanentMedia(String mediaId, String saveDir, String fileName) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		if (saveDir == null) {
			throw new NullPointerException("saveDir may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		PostData postData = new PostData(mediaId);
		
		return appContext.getWechatRequester().downloadMediaByPost(url, postData.toString(), saveDir, fileName);
	}
	
	/**
	 * 
	 * @param mediaId
	 * @param saveDir
	 * @param fileName a name will be created if null 
	 * @return null if network error
	 * @throws NullPointerException if mediaId or saveDir is null
	 */
	public DownloadResponse downloadTemporaryMedia(String mediaId, String saveDir, String fileName) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		if (saveDir == null) {
			throw new NullPointerException("saveDir may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", appContext.getAccessTokenFetcher().getAccessToken(), mediaId);
		return appContext.getWechatRequester().downloadMediaByGet(url, saveDir, fileName);
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public NewsFindResponse findNews(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		PostData postData = new PostData(mediaId);
		return appContext.getWechatRequester().postString(url, postData.toString(), NewsFindResponse.class);
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public VideoFindResponse findPermanentVideo(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		PostData postData = new PostData(mediaId);
		return appContext.getWechatRequester().postString(url, postData.toString(), VideoFindResponse.class);
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public TempVideoFindResponse findTemporaryVideo(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", appContext.getAccessTokenFetcher().getAccessToken(), mediaId);
		return appContext.getWechatRequester().get(url, TempVideoFindResponse.class);
	}
	
	private static class PostData extends JsonBean {
		@JsonProperty("media_id")
		private String mediaId;
		
		PostData(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
