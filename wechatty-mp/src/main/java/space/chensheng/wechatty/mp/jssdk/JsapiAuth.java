package space.chensheng.wechatty.mp.jssdk;

import java.io.Serializable;

public class JsapiAuth implements Serializable {
	private static final long serialVersionUID = 878210219141191746L;

	private String appId;
	
	private String timestamp;
	
	private String nonceStr;
	
	private String signature;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
