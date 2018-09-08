package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class RedPackResponse extends PayResponse {
	
	@XStreamAlias("mch_billno")
	@XStreamCDATA
	private String mchBillNo;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("wxappid")
	@XStreamCDATA
	private String wxAppId;
	
	@XStreamAlias("re_openid")
	@XStreamCDATA
	private String reOpenId;
	
	@XStreamAlias("total_amount")
	@XStreamCDATA
	private Integer totalAmount;
	
	@XStreamAlias("send_listid")
	@XStreamCDATA
	private String sendListId;

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

	public String getSendListId() {
		return sendListId;
	}

	public void setSendListId(String sendListId) {
		this.sendListId = sendListId;
	}
	
}
