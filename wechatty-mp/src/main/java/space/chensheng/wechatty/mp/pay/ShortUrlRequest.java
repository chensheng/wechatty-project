package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class ShortUrlRequest extends PayRequest {
	@XStreamAlias("appid")
	@XStreamCDATA
	private String appId;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("sign_type")
	@XStreamCDATA
	private String signType;
	
	@XStreamAlias("long_url")
	@XStreamCDATA
	private String longUrl;

	public String getAppId() {
		return appId;
	}

	/**
	 * Required
	 * @param appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	/**
	 * Required
	 * @param mchId
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	/**
	 * Required
	 * @param nonceStr
	 */
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignType() {
		return signType;
	}

	/**
	 * Default is 'MD5'
	 * @param signType
	 */
	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getLongUrl() {
		return longUrl;
	}

	/**
	 * Required
	 * @param longUrl
	 */
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
}
