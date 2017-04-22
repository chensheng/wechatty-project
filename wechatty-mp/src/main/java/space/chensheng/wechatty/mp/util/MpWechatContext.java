package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.PropOption;
import space.chensheng.wechatty.common.conf.WechatContext;

public class MpWechatContext extends WechatContext {
	private static final String DEFAULT_CONF_PATH = "/wechat-mp-default.properties";
	
	private static final String CUSTOMER_CONF_PATH = "/wechat-mp.properties";
	
	private static MpWechatContext instance = new MpWechatContext();
	
	public static MpWechatContext getInstance() {
		return instance;
	}
	
	@PropOption(notNull = true)
	private String token;
	
	@PropOption(notNull = true)
	private String aesKey;
	
	@PropOption(notNull = true)
	private String appId;
	
	@PropOption(notNull = true)
	private String appSecret;
	
	private MpWechatContext() {
		super(DEFAULT_CONF_PATH, CUSTOMER_CONF_PATH);
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
}
