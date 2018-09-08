package space.chensheng.wechatty.mp.jssdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import space.chensheng.wechatty.common.conf.AppContext;

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
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
	}
}
