package space.chensheng.wechatty.mp.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.http.BaseResponse;
import space.chensheng.wechatty.common.util.JsonMapper;

public class UserInfoQuery {
	private AppContext appContext;
	
	public UserInfoQuery(AppContext appContext) {
		this.appContext = appContext;
	}
	
	public UserInfoResponse get(String openId) {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN", appContext.getAccessTokenFetcher().getAccessToken(), openId);
		return appContext.getWechatRequester().get(url, UserInfoResponse.class);
	}
	
	public UserInfoBatchResponse batchGet(List<String> openIdList) {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		
		Map<String, Object> reqParam = new HashMap<String, Object>();
		List<Map<String, Object>> reqItems = new ArrayList<Map<String, Object>>();
		reqParam.put("user_list", reqItems);
		for (String openId : openIdList) {
			Map<String, Object> reqItem = new HashMap<String, Object>();
			reqItem.put("openid", openId);
			reqItem.put("lang", "zh_CN");
			reqItems.add(reqItem);
		}
		
		return appContext.getWechatRequester().postString(url, JsonMapper.nonEmptyMapper().toJson(reqParam), UserInfoBatchResponse.class);
	}
	
	public static class UserInfoResponse extends BaseResponse {
		private static final long serialVersionUID = 1689241897696675651L;
		
		private Integer subscribe;
		
		@JsonProperty("openid")
		private String openId;
		
		private String nickname;
		
		private Integer sex;
		
		private String language;
		
		private String city;
		
		private String province;
		
		private String country;
		
		@JsonProperty("headimgurl")
		private String headImgUrl;
		
		@JsonProperty("subscribetime")
		private Long subscribeTime;
		
		@JsonProperty("unionid")
		private String unionId;
		
		private String remark;
		
		@JsonProperty("groupid")
		private Integer groupId;
		
		@JsonProperty("tagid_list")
		private Integer[] tagidList;
		
		@JsonProperty("subscribe_scene")
		private String subscribeScene;
		
		@JsonProperty("qr_scene")
		private Integer qrScene;
		
		@JsonProperty("qr_scene_str")
		private String qrSceneStr;

		public Integer getSubscribe() {
			return subscribe;
		}

		public void setSubscribe(Integer subscribe) {
			this.subscribe = subscribe;
		}

		public String getOpenId() {
			return openId;
		}

		public void setOpenId(String openId) {
			this.openId = openId;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public Integer getSex() {
			return sex;
		}

		public void setSex(Integer sex) {
			this.sex = sex;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getHeadImgUrl() {
			return headImgUrl;
		}

		public void setHeadImgUrl(String headImgUrl) {
			this.headImgUrl = headImgUrl;
		}

		public Long getSubscribeTime() {
			return subscribeTime;
		}

		public void setSubscribeTime(Long subscribeTime) {
			this.subscribeTime = subscribeTime;
		}

		public String getUnionId() {
			return unionId;
		}

		public void setUnionId(String unionId) {
			this.unionId = unionId;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public Integer getGroupId() {
			return groupId;
		}

		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}

		public Integer[] getTagidList() {
			return tagidList;
		}

		public void setTagidList(Integer[] tagidList) {
			this.tagidList = tagidList;
		}

		public String getSubscribeScene() {
			return subscribeScene;
		}

		public void setSubscribeScene(String subscribeScene) {
			this.subscribeScene = subscribeScene;
		}

		public Integer getQrScene() {
			return qrScene;
		}

		public void setQrScene(Integer qrScene) {
			this.qrScene = qrScene;
		}

		public String getQrSceneStr() {
			return qrSceneStr;
		}

		public void setQrSceneStr(String qrSceneStr) {
			this.qrSceneStr = qrSceneStr;
		}
		
	}
	
	public static class UserInfoBatchResponse extends BaseResponse {
		private static final long serialVersionUID = -8701415448090482181L;
		
		@JsonProperty("user_info_list")
		private List<UserInfoResponse> userInfoList;

		public List<UserInfoResponse> getUserInfoList() {
			return userInfoList;
		}

		public void setUserInfoList(List<UserInfoResponse> userInfoList) {
			this.userInfoList = userInfoList;
		}
	}
}
