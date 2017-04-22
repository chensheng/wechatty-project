package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.DownloadResponse;
import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.util.JsonBean;
import space.chensheng.wechatty.mp.util.MpAccessTokenFetcher;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class MaterialFinder {
	
	/**
	 * 
	 * @param mediaId
	 * @param saveDir
	 * @param fileName a name will be created if null 
	 * @return null if network error
	 * @throws NullPointerException if mediaId or saveDir is null
	 */
	public static DownloadResponse downloadPermanentMedia(String mediaId, String saveDir, String fileName) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		if (saveDir == null) {
			throw new NullPointerException("saveDir may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", MpAccessTokenFetcher.getInstance().getAccessToken());
		PostData postData = new PostData(mediaId);
		
		return WechatRequester.downloadMediaByPost(url, postData.toString(), saveDir, fileName, MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}
	
	/**
	 * 
	 * @param mediaId
	 * @param saveDir
	 * @param fileName a name will be created if null 
	 * @return null if network error
	 * @throws NullPointerException if mediaId or saveDir is null
	 */
	public static DownloadResponse downloadTemporaryMedia(String mediaId, String saveDir, String fileName) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		if (saveDir == null) {
			throw new NullPointerException("saveDir may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", MpAccessTokenFetcher.getInstance().getAccessToken(), mediaId);
		return WechatRequester.downloadMediaByGet(url, saveDir, fileName, MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public static NewsFindResponse findNews(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", MpAccessTokenFetcher.getInstance().getAccessToken());
		PostData postData = new PostData(mediaId);
		return WechatRequester.postString(url, postData.toString(), NewsFindResponse.class, MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public static VideoFindResponse findPermanentVideo(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", MpAccessTokenFetcher.getInstance().getAccessToken());
		PostData postData = new PostData(mediaId);
		return WechatRequester.postString(url, postData.toString(), VideoFindResponse.class, MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}
	
	/**
	 * 
	 * @param mediaId
	 * @return null if network error
	 * @throws NullPointerException if mediaId is null
	 */
	public static TempVideoFindResponse findTemporaryVideo(String mediaId) {
		if (mediaId == null) {
			throw new NullPointerException("mediaId may not be null");
		}
		
		String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", MpAccessTokenFetcher.getInstance().getAccessToken(), mediaId);
		return WechatRequester.get(url, TempVideoFindResponse.class, MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance());
	}
	
	private static class PostData extends JsonBean {
		@JsonProperty("media_id")
		private String mediaId;
		
		PostData(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
