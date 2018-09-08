package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class TransfersRequest extends PayRequest {
	
	@XStreamAlias("mch_appid")
	@XStreamCDATA
	private String mchAppId;
	
	@XStreamAlias("mchid")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("partner_trade_no")
	@XStreamCDATA
	private String partnerTradeNo;
	
	@XStreamAlias("openid")
	@XStreamCDATA
	private String openId;
	
	@XStreamAlias("check_name")
	@XStreamCDATA
	private String checkName;
	
	@XStreamAlias("amount")
	@XStreamCDATA
	private Integer amount;
	
	@XStreamAlias("desc")
	@XStreamCDATA
	private String desc;
	
	@XStreamAlias("spbill_create_ip")
	@XStreamCDATA
	private String spbillCreateIp;
	
	@XStreamAlias("re_user_name")
	@XStreamCDATA
	private String reUserName;
	
	@XStreamAlias("device_info")
	@XStreamCDATA
	private String deviceInfo;

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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getReUserName() {
		return reUserName;
	}

	public void setReUserName(String reUserName) {
		this.reUserName = reUserName;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
}
