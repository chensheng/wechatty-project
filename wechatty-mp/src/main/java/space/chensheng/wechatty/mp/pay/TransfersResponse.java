package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class TransfersResponse extends PayResponse {
	
	@XStreamAlias("mch_appid")
	@XStreamCDATA
	private String mchAppId;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("device_info")
	@XStreamCDATA
	private String deviceInfo;
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("partner_trade_no")
	@XStreamCDATA
	private String partnerTradeNo;
	
	@XStreamAlias("payment_no")
	@XStreamCDATA
	private String paymentNo;
	
	@XStreamAlias("payment_time")
	@XStreamCDATA
	private String paymentTime;

	public String getMchAppId() {
		return mchAppId;
	}

	public void setMchAppId(String mchAppId) {
		this.mchAppId = mchAppId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}
	
}
