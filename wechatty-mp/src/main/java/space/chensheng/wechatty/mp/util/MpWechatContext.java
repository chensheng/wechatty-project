package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.WechatContext;

public class MpWechatContext extends WechatContext {
	private static final String DEFAULT_CONF_PATH = "/wechat-mp-default.properties";
	
	private static final String CUSTOMER_CONF_PATH = "/wechat-mp.properties";
	
	private String token;
	
	private String aesKey;
	
	private String appId;
	
	private String appSecret;
	
	private String payKey;
	
	private String payCertFile;
	
	private String payCertPassword;
	
	private String payMchId;
	
	private String payClientIp;
	
	private String payNotifyUrl;
	
	private String refundNotifyUrl;
	
	public MpWechatContext() {
		this(CUSTOMER_CONF_PATH);
	}
	
	public MpWechatContext(String customerConfPath) {
		super(DEFAULT_CONF_PATH, customerConfPath);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public String getPayCertFile() {
		return payCertFile;
	}

	public void setPayCertFile(String payCertFile) {
		this.payCertFile = payCertFile;
	}

	public String getPayCertPassword() {
		return payCertPassword;
	}

	public void setPayCertPassword(String payCertPassword) {
		this.payCertPassword = payCertPassword;
	}

	public String getPayMchId() {
		return payMchId;
	}

	public void setPayMchId(String payMchId) {
		this.payMchId = payMchId;
	}

	public String getPayClientIp() {
		return payClientIp;
	}

	public void setPayClientIp(String payClientIp) {
		this.payClientIp = payClientIp;
	}

	public String getPayNotifyUrl() {
		return payNotifyUrl;
	}

	public void setPayNotifyUrl(String payNotifyUrl) {
		this.payNotifyUrl = payNotifyUrl;
	}

	public String getRefundNotifyUrl() {
		return refundNotifyUrl;
	}

	public void setRefundNotifyUrl(String refundNotifyUrl) {
		this.refundNotifyUrl = refundNotifyUrl;
	}

	@Override
	public String getContextId() {
		return appId;
	}
}
