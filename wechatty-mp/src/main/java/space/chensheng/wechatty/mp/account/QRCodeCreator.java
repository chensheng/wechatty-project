package space.chensheng.wechatty.mp.account;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.http.BaseResponse;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.JsonBean;
import space.chensheng.wechatty.common.util.StringUtil;

public class QRCodeCreator {
	private static final Logger logger = LoggerFactory.getLogger(QRCodeCreator.class);
	
	private AppContext appContext;
	
	public QRCodeCreator(AppContext appContext) {
		this.appContext = appContext;
	}
	
	/**
	 * create temporary QRCode, it will expire in {@code expireSeconds}
	 * @param expireSeconds {@code >= 30 && <= 2592000}, 30 seconds to 30 days
	 * @param sceneId
	 * @return null if network error
	 */
	public QRCodeResponse createTemporary(int expireSeconds, int sceneId) {
		PostData postData = PostData.createTemporaryPostData(expireSeconds, sceneId);
		return doCreate(postData);
	}
	
	/**
	 * create temporary QRCode, it will expire in {@code expireSeconds}
	 * @param expireSeconds {@code >= 30 && <= 2592000}, 30 seconds to 30 days
	 * @param sceneStr length is 1 to 64
	 * @return null if network error
	 */
	public QRCodeResponse createTemporary(int expireSeconds, String sceneStr) {
		PostData postData = PostData.createTemporaryPostData(expireSeconds, sceneStr);
		return doCreate(postData);
	}
	
	/**
	 * create permanent QRCode with sceneId
	 * @param sceneId {@code >= 1 && <= 100000}
	 * @return null if network error
	 */
	public QRCodeResponse createPermanent(int sceneId) {
		PostData postData = PostData.createPermanentPostData(sceneId);
		return doCreate(postData);
	}
	
	/**
	 * create permanent QRCode with sceneStr
	 * @param sceneStr
	 * @return null if network error
	 */
	public QRCodeResponse createPermanent(String sceneStr) {
		PostData postData = PostData.createPermanentPostData(sceneStr);
		return doCreate(postData);
	}
	
	private QRCodeResponse doCreate(PostData postData) {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		return appContext.getWechatRequester().postString(url, postData.toString(), QRCodeResponse.class);
	}
	
	private static class PostData extends JsonBean {
		
		@JsonProperty("expire_seconds")
		private Integer expireSeconds;
		
		@JsonProperty("action_name")
		private String actionName;
	
		@JsonProperty("action_info")
		private ActionInfo actionInfo = new ActionInfo();
		
		private PostData() {
		}
		
		static PostData createTemporaryPostData(int expireSeconds, int sceneId) {
			if (expireSeconds < 30) {
				expireSeconds = 30;
			} else if (expireSeconds > 2592000) {
				expireSeconds = 2592000;
			}
			
			PostData result = new PostData();
			result.expireSeconds = expireSeconds;
			result.actionName = "QR_SCENE";
			result.actionInfo.scene.sceneId = sceneId;
			return result;
		}
		
		static PostData createTemporaryPostData(int expireSeconds, String sceneStr) {
			if (expireSeconds < 30) {
				expireSeconds = 30;
			} else if (expireSeconds > 2592000) {
				expireSeconds = 2592000;
			}
			
			PostData result = new PostData();
			result.expireSeconds = expireSeconds;
			result.actionName = "QR_STR_SCENE";
			result.actionInfo.scene.sceneStr = sceneStr;
			return result;
		}
		
		static PostData createPermanentPostData(int sceneId) {
			if (sceneId < 1) {
				sceneId = 1;
			} else if (sceneId > 100000) {
				sceneId = 100000;
			}
			
			PostData result = new PostData();
			result.actionName = "QR_LIMIT_SCENE";
			result.actionInfo.scene.sceneId = sceneId;
			return result;
		}
		
		static PostData createPermanentPostData(String sceneStr) {
			PostData result = new PostData();
			result.actionName = "QR_LIMIT_STR_SCENE";
			result.actionInfo.scene.sceneStr = sceneStr;
			return result;
		}
	}
	
	private static class ActionInfo {
		@JsonProperty
		Scene scene = new Scene();
	}
	
	private static class Scene {
		@JsonProperty("scene_id")
		Integer sceneId;
		
		@JsonProperty("scene_str")
		String sceneStr;
	}
	
	public static class QRCodeResponse extends BaseResponse {
		private static final long serialVersionUID = -7208516766118217986L;

		private String ticket;
		
		@JsonProperty("expire_seconds")
		private Integer expireSeconds;
		
		private String url;

		public String getTicket() {
			return ticket;
		}

		public void setTicket(String ticket) {
			this.ticket = ticket;
		}

		public Integer getExpireSeconds() {
			return expireSeconds;
		}

		public void setExpireSeconds(Integer expireSeconds) {
			this.expireSeconds = expireSeconds;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		
		public String getImageUrl() {
			if (StringUtil.isNotEmpty(ticket)) {
				try {
					return String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", URLEncoder.encode(ticket, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
			return null;
		}
	}
}
