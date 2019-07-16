package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class RefundResponse extends PayResponse {
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
	
	@XStreamAlias("refund_id")
	@XStreamCDATA
	private String refundId;
	
	@XStreamAlias("refund_fee")
	@XStreamCDATA
	private Integer refundFee;
	
	@XStreamAlias("settlement_refund_fee")
	@XStreamCDATA
	private Integer settlementRefundFee;
	
	@XStreamAlias("total_fee")
	@XStreamCDATA
	private Integer totalFee;
	
	@XStreamAlias("settlement_total_fee")
	@XStreamCDATA
	private Integer settlementTotalFee;
	
	@XStreamAlias("fee_type")
	@XStreamCDATA
	private String feeType;
	
	@XStreamAlias("cash_fee")
	@XStreamCDATA
	private Integer cashFee;
	
	@XStreamAlias("cash_fee_type")
	@XStreamCDATA
	private String cashFeeType;
	
	@XStreamAlias("cash_refund_fee")
	@XStreamCDATA
	private Integer cashRefundFee;
	
	@XStreamAlias("coupon_refund_fee")
	@XStreamCDATA
	private Integer couponRefundFee;
	
	@XStreamAlias("coupon_refund_count")
	@XStreamCDATA
	private Integer couponRefundCount;
	
	@XStreamAlias("coupon_type_0")
	@XStreamCDATA
	private String couponType0;
	
	@XStreamAlias("coupon_refund_id_0")
	@XStreamCDATA
	private String couponRefundId0;
	
	@XStreamAlias("coupon_refund_fee_0")
	@XStreamCDATA
	private Integer couponRefundFee0;
	
	@XStreamAlias("coupon_type_1")
	@XStreamCDATA
	private String couponType1;
	
	@XStreamAlias("coupon_refund_id_1")
	@XStreamCDATA
	private String couponRefundId1;
	
	@XStreamAlias("coupon_refund_fee_1")
	@XStreamCDATA
	private Integer couponRefundFee1;
	
	@XStreamAlias("coupon_type_2")
	@XStreamCDATA
	private String couponType2;
	
	@XStreamAlias("coupon_refund_id_2")
	@XStreamCDATA
	private String couponRefundId2;
	
	@XStreamAlias("coupon_refund_fee_2")
	@XStreamCDATA
	private Integer couponRefundFee2;
	
	@XStreamAlias("coupon_type_3")
	@XStreamCDATA
	private String couponType3;
	
	@XStreamAlias("coupon_refund_id_3")
	@XStreamCDATA
	private String couponRefundId3;
	
	@XStreamAlias("coupon_refund_fee_3")
	@XStreamCDATA
	private Integer couponRefundFee3;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
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

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public Integer getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	public Integer getSettlementRefundFee() {
		return settlementRefundFee;
	}

	public void setSettlementRefundFee(Integer settlementRefundFee) {
		this.settlementRefundFee = settlementRefundFee;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
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

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public Integer getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(Integer cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}

	public Integer getCouponRefundFee() {
		return couponRefundFee;
	}

	public void setCouponRefundFee(Integer couponRefundFee) {
		this.couponRefundFee = couponRefundFee;
	}

	public Integer getCouponRefundCount() {
		return couponRefundCount;
	}

	public void setCouponRefundCount(Integer couponRefundCount) {
		this.couponRefundCount = couponRefundCount;
	}

	public String getCouponType0() {
		return couponType0;
	}

	public void setCouponType0(String couponType0) {
		this.couponType0 = couponType0;
	}

	public String getCouponRefundId0() {
		return couponRefundId0;
	}

	public void setCouponRefundId0(String couponRefundId0) {
		this.couponRefundId0 = couponRefundId0;
	}

	public Integer getCouponRefundFee0() {
		return couponRefundFee0;
	}

	public void setCouponRefundFee0(Integer couponRefundFee0) {
		this.couponRefundFee0 = couponRefundFee0;
	}

	public String getCouponType1() {
		return couponType1;
	}

	public void setCouponType1(String couponType1) {
		this.couponType1 = couponType1;
	}

	public String getCouponRefundId1() {
		return couponRefundId1;
	}

	public void setCouponRefundId1(String couponRefundId1) {
		this.couponRefundId1 = couponRefundId1;
	}

	public Integer getCouponRefundFee1() {
		return couponRefundFee1;
	}

	public void setCouponRefundFee1(Integer couponRefundFee1) {
		this.couponRefundFee1 = couponRefundFee1;
	}

	public String getCouponType2() {
		return couponType2;
	}

	public void setCouponType2(String couponType2) {
		this.couponType2 = couponType2;
	}

	public String getCouponRefundId2() {
		return couponRefundId2;
	}

	public void setCouponRefundId2(String couponRefundId2) {
		this.couponRefundId2 = couponRefundId2;
	}

	public Integer getCouponRefundFee2() {
		return couponRefundFee2;
	}

	public void setCouponRefundFee2(Integer couponRefundFee2) {
		this.couponRefundFee2 = couponRefundFee2;
	}

	public String getCouponType3() {
		return couponType3;
	}

	public void setCouponType3(String couponType3) {
		this.couponType3 = couponType3;
	}

	public String getCouponRefundId3() {
		return couponRefundId3;
	}

	public void setCouponRefundId3(String couponRefundId3) {
		this.couponRefundId3 = couponRefundId3;
	}

	public Integer getCouponRefundFee3() {
		return couponRefundFee3;
	}

	public void setCouponRefundFee3(Integer couponRefundFee3) {
		this.couponRefundFee3 = couponRefundFee3;
	}
	
}
