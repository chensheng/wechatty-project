package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class RefundRequest extends PayRequest {
	@XStreamAlias("appid")
	@XStreamCDATA
	private String appId;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("transaction_id")
	@XStreamCDATA
	private String transactionId;
	
	@XStreamAlias("out_trade_no")
	@XStreamCDATA
	private String outTradeNo;
	
	@XStreamAlias("out_refund_no")
	@XStreamCDATA
	private String outRefundNo;
	
	@XStreamAlias("total_fee")
	@XStreamCDATA
	private Integer totalFee;
	
	@XStreamAlias("refund_fee")
	@XStreamCDATA
	private Integer refundFee;
	
	@XStreamAlias("notify_url")
	@XStreamCDATA
	private String notifyUrl;
	
	@XStreamAlias("sign_type")
	@XStreamCDATA
	private String signType;
	
	@XStreamAlias("refund_fee_type")
	@XStreamCDATA
	private String refundFeeType;
	
	@XStreamAlias("refund_desc")
	@XStreamCDATA
	private String refundDesc;
	
	@XStreamAlias("refund_account")
	@XStreamCDATA
	private String refundAccount;
	
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

	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Required if outTradeNo is null
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * Required if transactionId is null
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	/**
	 * Required
	 * @param outRefundNo
	 */
	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	/**
	 * Required. Unit FEN
	 * @param totalFee
	 */
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getRefundFee() {
		return refundFee;
	}

	/**
	 * Required. Unit FEN
	 * @param refundFee
	 */
	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	/**
	 * Required
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
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

	public String getRefundFeeType() {
		return refundFeeType;
	}

	/**
	 * Default is 'CNY'
	 * @param refundFeeType
	 */
	public void setRefundFeeType(String refundFeeType) {
		this.refundFeeType = refundFeeType;
	}

	public String getRefundDesc() {
		return refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}
	
}
