package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.http.AbstractAccessTokenFetcher;

public class MpAccessTokenFetcher extends AbstractAccessTokenFetcher {
	public MpAccessTokenFetcher(MpAppContext appContext, MpWechatContext wechatContext) {
		super(String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", 
				wechatContext.getAppId(), wechatContext.getAppSecret()), appContext);
	}
}
