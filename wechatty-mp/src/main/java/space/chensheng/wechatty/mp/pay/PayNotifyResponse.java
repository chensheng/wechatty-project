package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class PayNotifyResponse extends PayResponse {
	@XStreamAlias("return_code")
	@XStreamCDATA
	protected String returnCode;
	
	@XStreamAlias("return_msg")
	@XStreamCDATA
	protected String returnMsg;
	
	@XStreamAlias("sign")
	@XStreamCDATA
	protected String sign;
	
	@XStreamAlias("result_code")
	@XStreamCDATA
	protected String resultCode;

	@XStreamAlias("err_code")
	@XStreamCDATA
	private String errCode;
	
	@XStreamAlias("err_code_des")
	@XStreamCDATA
	private String errCodeDes;
	
	@XStreamAlias("appid")
	@XStreamCDATA
	private String appId;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("openid")
	@XStreamCDATA
	private String openId;
	
	@XStreamAlias("trade_type")
	@XStreamCDATA
	private String tradeType;
	
	@XStreamAlias("bank_type")
	@XStreamCDATA
	private String bankType;
	
	@XStreamAlias("total_fee")
	@XStreamCDATA
	private Integer totalFee;
	
	@XStreamAlias("cash_fee")
	@XStreamCDATA
	private Integer cashFee;
	
	@XStreamAlias("transaction_id")
	@XStreamCDATA
	private String transactionId;
	
	@XStreamAlias("out_trade_no")
	@XStreamCDATA
	private String outTradeNo;
	
	@XStreamAlias("time_end")
	@XStreamCDATA
	private String timeEnd;
	
	@XStreamAlias("device_info")
	@XStreamCDATA
	private String deviceInfo;
	
	@XStreamAlias("sign_type")
	@XStreamCDATA
	private String signType;
	
	@XStreamAlias("is_subscribe")
	@XStreamCDATA
	private String isSubscribe;
	
	@XStreamAlias("settlement_total_fee")
	@XStreamCDATA
	private Integer settlementTotalFee;
	
	@XStreamAlias("fee_type")
	@XStreamCDATA
	private String feeType;
	
	@XStreamAlias("cash_fee_type")
	@XStreamCDATA
	private String cashFeeType;
	
	@XStreamAlias("coupon_fee")
	@XStreamCDATA
	private Integer couponFee;
	
	@XStreamAlias("coupon_count")
	@XStreamCDATA
	private Integer couponCount;
	
	@XStreamAlias("attach")
	@XStreamCDATA
	private String attach;
	
	@XStreamAlias("coupon_type_0")
	@XStreamCDATA
	private String couponType0;
	
	@XStreamAlias("coupon_id_0")
	@XStreamCDATA
	private String couponId0;
	
	@XStreamAlias("coupon_fee_0")
	@XStreamCDATA
	private Integer couponFee0;
	
	@XStreamAlias("coupon_type_1")
	@XStreamCDATA
	private String couponType1;
	
	@XStreamAlias("coupon_id_1")
	@XStreamCDATA
	private String couponId1;
	
	@XStreamAlias("coupon_fee_1")
	@XStreamCDATA
	private Integer couponFee1;
	
	@XStreamAlias("coupon_type_2")
	@XStreamCDATA
	private String couponType2;
	
	@XStreamAlias("coupon_id_2")
	@XStreamCDATA
	private String couponId2;
	
	@XStreamAlias("coupon_fee_2")
	@XStreamCDATA
	private Integer couponFee2;
	
	@XStreamAlias("coupon_type_3")
	@XStreamCDATA
	private String couponType3;
	
	@XStreamAlias("coupon_id_3")
	@XStreamCDATA
	private String couponId3;
	
	@XStreamAlias("coupon_fee_3")
	@XStreamCDATA
	private Integer couponFee3;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	/**
	 * Not null
	 * @return
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * Not null
	 * @return
	 */
	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Not null
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * Not null, format is 'yyyyMMddHHmmss'
	 * @return
	 */
	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public Integer getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getCouponType0() {
		return couponType0;
	}

	public void setCouponType0(String couponType0) {
		this.couponType0 = couponType0;
	}

	public String getCouponId0() {
		return couponId0;
	}

	public void setCouponId0(String couponId0) {
		this.couponId0 = couponId0;
	}

	public Integer getCouponFee0() {
		return couponFee0;
	}

	public void setCouponFee0(Integer couponFee0) {
		this.couponFee0 = couponFee0;
	}

	public String getCouponType1() {
		return couponType1;
	}

	public void setCouponType1(String couponType1) {
		this.couponType1 = couponType1;
	}

	public String getCouponId1() {
		return couponId1;
	}

	public void setCouponId1(String couponId1) {
		this.couponId1 = couponId1;
	}

	public Integer getCouponFee1() {
		return couponFee1;
	}

	public void setCouponFee1(Integer couponFee1) {
		this.couponFee1 = couponFee1;
	}

	public String getCouponType2() {
		return couponType2;
	}

	public void setCouponType2(String couponType2) {
		this.couponType2 = couponType2;
	}

	public String getCouponId2() {
		return couponId2;
	}

	public void setCouponId2(String couponId2) {
		this.couponId2 = couponId2;
	}

	public Integer getCouponFee2() {
		return couponFee2;
	}

	public void setCouponFee2(Integer couponFee2) {
		this.couponFee2 = couponFee2;
	}

	public String getCouponType3() {
		return couponType3;
	}

	public void setCouponType3(String couponType3) {
		this.couponType3 = couponType3;
	}

	public String getCouponId3() {
		return couponId3;
	}

	public void setCouponId3(String couponId3) {
		this.couponId3 = couponId3;
	}

	public Integer getCouponFee3() {
		return couponFee3;
	}

	public void setCouponFee3(Integer couponFee3) {
		this.couponFee3 = couponFee3;
	}
	
}
