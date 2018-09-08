package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.http.AccessTokenFetcher;

public class MpAccessTokenFetcher extends AccessTokenFetcher {
	
	public MpAccessTokenFetcher(AppContext appContext) {
		super(String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", 
				((MpWechatContext)(appContext.getWechatContext())).getAppId(), 
				((MpWechatContext)(appContext.getWechatContext())).getAppSecret()), appContext);
	}
	
}
