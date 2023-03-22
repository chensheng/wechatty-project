package space.chensheng.wechatty.mp.auth;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.mp.util.MpAppContext;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class AuthHelper {
	private AppContext appContext;
	
	public AuthHelper(MpAppContext appContext) {
		this.appContext = appContext;
	}
	
	public AuthAccessTokenResponse fetchAuthAccessToken(String code) {
		String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", 
				getWechatContext().getAppId(), getWechatContext().getAppSecret(), code);
		
		return appContext.getWechatRequester().get(url, AuthAccessTokenResponse.class);
	}
	
	public AuthAccessTokenResponse refreshAuthAccessToken(String refreshToken) {
		String url = String.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s", 
				getWechatContext().getAppId(), refreshToken);
		return appContext.getWechatRequester().get(url, AuthAccessTokenResponse.class);
	}
	
	public AuthUserInfoResponse fetchAuthUserInfo(String authAccessToken, String openId) {
		String url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", authAccessToken, openId);
		return appContext.getWechatRequester().get(url, AuthUserInfoResponse.class);
	}

	private MpWechatContext getWechatContext() {
		return (MpWechatContext) appContext.getWechatContext();
	}
}
