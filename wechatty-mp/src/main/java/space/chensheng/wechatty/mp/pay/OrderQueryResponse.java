package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class OrderQueryResponse extends PayResponse {
	@XStreamAlias("openid")
	@XStreamCDATA
	private String openId;
	
	@XStreamAlias("trade_type")
	@XStreamCDATA
	private String tradeType;
	
	@XStreamAlias("trade_state")
	@XStreamCDATA
	private String tradeState;
	
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
	
	@XStreamAlias("trade_state_desc")
	@XStreamCDATA
	private String tradeStateDesc;
	
	@XStreamAlias("device_info")
	@XStreamCDATA
	private String deviceInfo;
	
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
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
