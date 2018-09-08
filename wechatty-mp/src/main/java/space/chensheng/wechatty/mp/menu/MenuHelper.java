package space.chensheng.wechatty.mp.menu;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.http.BaseResponse;

public class MenuHelper {
	private AppContext appContext;
	
	public MenuHelper(AppContext appContext) {
		this.appContext = appContext;
	}
	
	public BaseResponse createMenu(String menuJson) {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", appContext.getAccessTokenFetcher().getAccessToken());
		return appContext.getWechatRequester().postString(url, menuJson, BaseResponse.class);
	}
}
