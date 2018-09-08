package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class GroupRedPackRequest extends PayRequest {
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("mch_billno")
	@XStreamCDATA
	private String mchBillNo;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("wxappid")
	@XStreamCDATA
	private String wxAppId;
	
	@XStreamAlias("send_name")
	@XStreamCDATA
	private String sendName;
	
	@XStreamAlias("re_openid")
	@XStreamCDATA
	private String reOpenId;
	
	@XStreamAlias("total_amount")
	@XStreamCDATA
	private Integer totalAmount;
	
	@XStreamAlias("total_num")
	@XStreamCDATA
	private Integer totalNum;
	
	@XStreamAlias("amt_type")
	@XStreamCDATA
	private String amtType;
	
	@XStreamAlias("wishing")
	@XStreamCDATA
	private String wishing;
	
	@XStreamAlias("client_ip")
	@XStreamCDATA
	private String clientIp;
	
	@XStreamAlias("act_name")
	@XStreamCDATA
	private String actName;
	
	@XStreamAlias("remark")
	@XStreamCDATA
	private String remark;
	
	@XStreamAlias("scene_id")
	@XStreamCDATA
	private String sceneId;
	
	@XStreamAlias("risk_info")
	@XStreamCDATA
	private String riskInfo;
	
	@XStreamAlias("consume_mch_id")
	@XStreamCDATA
	private String consumeMchId;

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getMchBillNo() {
		return mchBillNo;
	}

	public void setMchBillNo(String mchBillNo) {
		this.mchBillNo = mchBillNo;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getWxAppId() {
		return wxAppId;
	}

	public void setWxAppId(String wxAppId) {
		this.wxAppId = wxAppId;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getReOpenId() {
		return reOpenId;
	}

	public void setReOpenId(String reOpenId) {
		this.reOpenId = reOpenId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public String getAmtType() {
		return amtType;
	}

	public void setAmtType(String amtType) {
		this.amtType = amtType;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSceneId() {
		return sceneId;
	}

	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getConsumeMchId() {
		return consumeMchId;
	}

	public void setConsumeMchId(String consumeMchId) {
		this.consumeMchId = consumeMchId;
	}
	
}
