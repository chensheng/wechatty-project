package space.chensheng.wechatty.mp.jssdk;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.util.SHA1Utils;
import space.chensheng.wechatty.common.util.StringUtil;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class JsapiHelper {
	private AppContext appContext;
	
	public JsapiHelper(AppContext appContext) {
		this.appContext = appContext;
	}
	
	public String fetchTicket() {
		String url = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", appContext.getAccessTokenFetcher().getAccessToken());
		
		JsapiTicketResponse resp = appContext.getWechatRequester().get(url, JsapiTicketResponse.class);
		if (resp != null) {
			return resp.getTicket();
		}
		
		return "";
	}

	public String fetchTicket(WechatContext wechatContext) {
		if(wechatContext == null) {
			return fetchTicket();
		}

		WechatContext originalWechatContext = appContext.getWechatContext();
		try {
			appContext.switchWechatContext(wechatContext.getContextId());
			return fetchTicket();
		} finally {
			if(originalWechatContext != null) {
				appContext.switchWechatContext(originalWechatContext.getContextId());
			} else {
				appContext.switchWechatContext(null);
			}
		}
	}
	
	public JsapiAuth generateSignature(String jsapiTicket, String url) {
		JsapiAuth auth = new JsapiAuth();
		
		String nonceStr = StringUtil.getRandomStr();
		long timestamp = System.currentTimeMillis();
		String signature = this.generateSignature(jsapiTicket, nonceStr, timestamp, url);
		
		MpWechatContext wechatContext = (MpWechatContext) appContext.getWechatContext();
		auth.setAppId(wechatContext.getAppId());
		auth.setNonceStr(nonceStr);
		auth.setTimestamp(String.valueOf(timestamp));
		auth.setSignature(signature);
		return auth;
	}
	
	public String generateSignature(String jsapiTicket, String nonceStr, long timestamp, String url) {
		StringBuilder params = new StringBuilder();
		
		params.append("jsapi_ticket=");
		params.append(jsapiTicket);
		
		params.append("&");
		params.append("noncestr=");
		params.append(nonceStr);
		
		params.append("&");
		params.append("timestamp=");
		params.append(timestamp);
		
		params.append("&");
		params.append("url=");
		params.append(url);
		
		String str = params.toString();
		return SHA1Utils.encode(str);
	}
}
