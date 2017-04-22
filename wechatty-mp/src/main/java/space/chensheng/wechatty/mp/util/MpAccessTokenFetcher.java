package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.http.AccessTokenFetcher;

public class MpAccessTokenFetcher extends AccessTokenFetcher {
	private volatile static MpAccessTokenFetcher instance;
	
	public static MpAccessTokenFetcher getInstance() {
		if (instance == null) {
			synchronized(MpAccessTokenFetcher.class) {
				if (instance == null) {
					String getTokenUrl = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", 
							MpWechatContext.getInstance().getAppId(), MpWechatContext.getInstance().getAppSecret());
					instance = new MpAccessTokenFetcher(getTokenUrl, MpWechatContext.getInstance());
				}
			}
		}
		return instance;
	}

	private MpAccessTokenFetcher(String getTokenUrl, WechatContext wechatContext) {
		super(getTokenUrl, wechatContext);
	}

}
