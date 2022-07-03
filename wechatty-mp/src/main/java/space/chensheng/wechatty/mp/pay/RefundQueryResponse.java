package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class RefundQueryResponse extends PayResponse {
	@XStreamAlias("total_refund_count")
	@XStreamCDATA
	private Integer totalRefundCount;

	@XStreamAlias("transaction_id")
	@XStreamCDATA
	private String transactionId;

	@XStreamAlias("out_trade_no")
	@XStreamCDATA
	private String outTradeNo;

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

	@XStreamAlias("refund_count")
	@XStreamCDATA
	private Integer refundCount;

	@XStreamAlias("out_refund_no_0")
	@XStreamCDATA
	private String outRefundNo0;

	@XStreamAlias("out_refund_no_1")
	@XStreamCDATA
	private String outRefundNo1;

	@XStreamAlias("out_refund_no_2")
	@XStreamCDATA
	private String outRefundNo2;

	@XStreamAlias("out_refund_no_3")
	@XStreamCDATA
	private String outRefundNo3;

	@XStreamAlias("refund_id_0")
	@XStreamCDATA
	private String refundId0;

	@XStreamAlias("refund_id_1")
	@XStreamCDATA
	private String refundId1;

	@XStreamAlias("refund_id_2")
	@XStreamCDATA
	private String refundId2;

	@XStreamAlias("refund_id_3")
	@XStreamCDATA
	private String refundId3;

	@XStreamAlias("refund_channel_0")
	@XStreamCDATA
	private String refundChannel0;

	@XStreamAlias("refund_channel_1")
	@XStreamCDATA
	private String refundChannel1;

	@XStreamAlias("refund_channel_2")
	@XStreamCDATA
	private String refundChannel2;

	@XStreamAlias("refund_channel_3")
	@XStreamCDATA
	private String refundChannel3;

	@XStreamAlias("refund_fee_0")
	@XStreamCDATA
	private Integer refundFee0;

	@XStreamAlias("refund_fee_1")
	@XStreamCDATA
	private Integer refundFee1;

	@XStreamAlias("refund_fee_2")
	@XStreamCDATA
	private Integer refundFee2;

	@XStreamAlias("refund_fee_3")
	@XStreamCDATA
	private Integer refundFee3;

	@XStreamAlias("refund_fee")
	@XStreamCDATA
	private Integer refundFee;

	@XStreamAlias("coupon_refund_fee")
	@XStreamCDATA
	private Integer couponRefundFee;

	@XStreamAlias("settlement_refund_fee_0")
	@XStreamCDATA
	private Integer settlementRefundFee0;

	@XStreamAlias("settlement_refund_fee_1")
	@XStreamCDATA
	private Integer settlementRefundFee1;

	@XStreamAlias("settlement_refund_fee_2")
	@XStreamCDATA
	private Integer settlementRefundFee2;

	@XStreamAlias("settlement_refund_fee_3")
	@XStreamCDATA
	private Integer settlementRefundFee3;

	@XStreamAlias("coupon_refund_fee_0")
	@XStreamCDATA
	private Integer couponRefundFee0;

	@XStreamAlias("coupon_refund_fee_1")
	@XStreamCDATA
	private Integer couponRefundFee1;

	@XStreamAlias("coupon_refund_fee_2")
	@XStreamCDATA
	private Integer couponRefundFee2;

	@XStreamAlias("coupon_refund_fee_3")
	@XStreamCDATA
	private Integer couponRefundFee3;

	@XStreamAlias("coupon_type_0")
	@XStreamCDATA
	private String couponType0;

	@XStreamAlias("coupon_type_1")
	@XStreamCDATA
	private String couponType1;

	@XStreamAlias("coupon_type_2")
	@XStreamCDATA
	private String couponType2;

	@XStreamAlias("coupon_type_3")
	@XStreamCDATA
	private String couponType3;

	@XStreamAlias("coupon_refund_count_0")
	@XStreamCDATA
	private Integer couponRefundCount0;

	@XStreamAlias("coupon_refund_count_1")
	@XStreamCDATA
	private Integer couponRefundCount1;

	@XStreamAlias("coupon_refund_count_2")
	@XStreamCDATA
	private Integer couponRefundCount2;

	@XStreamAlias("coupon_refund_count_3")
	@XStreamCDATA
	private Integer couponRefundCount3;

	@XStreamAlias("refund_status_0")
	@XStreamCDATA
	private String refundStatus0;

	@XStreamAlias("refund_status_1")
	@XStreamCDATA
	private String refundStatus1;

	@XStreamAlias("refund_status_2")
	@XStreamCDATA
	private String refundStatus2;

	@XStreamAlias("refund_status_3")
	@XStreamCDATA
	private String refundStatus3;

	@XStreamAlias("refund_account_0")
	@XStreamCDATA
	private String refundAccount0;

	@XStreamAlias("refund_account_1")
	@XStreamCDATA
	private String refundAccount1;

	@XStreamAlias("refund_account_2")
	@XStreamCDATA
	private String refundAccount2;

	@XStreamAlias("refund_account_3")
	@XStreamCDATA
	private String refundAccount3;

	@XStreamAlias("refund_recv_account_0")
	@XStreamCDATA
	private String refundRecvAccount0;

	@XStreamAlias("refund_recv_account_1")
	@XStreamCDATA
	private String refundRecvAccount1;

	@XStreamAlias("refund_recv_account_2")
	@XStreamCDATA
	private String refundRecvAccount2;

	@XStreamAlias("refund_recv_account_3")
	@XStreamCDATA
	private String refundRecvAccount3;

	@XStreamAlias("refund_success_time_0")
	@XStreamCDATA
	private String refundSuccessTime0;

	@XStreamAlias("refund_success_time_1")
	@XStreamCDATA
	private String refundSuccessTime1;

	@XStreamAlias("refund_success_time_2")
	@XStreamCDATA
	private String refundSuccessTime2;

	@XStreamAlias("refund_success_time_3")
	@XStreamCDATA
	private String refundSuccessTime3;

	@XStreamAlias("cash_refund_fee")
	@XStreamCDATA
	private Integer cashRefundFee;

	public Integer getTotalRefundCount() {
		return totalRefundCount;
	}

	public void setTotalRefundCount(Integer totalRefundCount) {
		this.totalRefundCount = totalRefundCount;
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

	public Integer getRefundCount() {
		return refundCount;
	}

	public void setRefundCount(Integer refundCount) {
		this.refundCount = refundCount;
	}

	public String getOutRefundNo0() {
		return outRefundNo0;
	}

	public void setOutRefundNo0(String outRefundNo0) {
		this.outRefundNo0 = outRefundNo0;
	}

	public String getOutRefundNo1() {
		return outRefundNo1;
	}

	public void setOutRefundNo1(String outRefundNo1) {
		this.outRefundNo1 = outRefundNo1;
	}

	public String getOutRefundNo2() {
		return outRefundNo2;
	}

	public void setOutRefundNo2(String outRefundNo2) {
		this.outRefundNo2 = outRefundNo2;
	}

	public String getOutRefundNo3() {
		return outRefundNo3;
	}

	public void setOutRefundNo3(String outRefundNo3) {
		this.outRefundNo3 = outRefundNo3;
	}

	public String getRefundId0() {
		return refundId0;
	}

	public void setRefundId0(String refundId0) {
		this.refundId0 = refundId0;
	}

	public String getRefundId1() {
		return refundId1;
	}

	public void setRefundId1(String refundId1) {
		this.refundId1 = refundId1;
	}

	public String getRefundId2() {
		return refundId2;
	}

	public void setRefundId2(String refundId2) {
		this.refundId2 = refundId2;
	}

	public String getRefundId3() {
		return refundId3;
	}

	public void setRefundId3(String refundId3) {
		this.refundId3 = refundId3;
	}

	public String getRefundChannel0() {
		return refundChannel0;
	}

	public void setRefundChannel0(String refundChannel0) {
		this.refundChannel0 = refundChannel0;
	}

	public String getRefundChannel1() {
		return refundChannel1;
	}

	public void setRefundChannel1(String refundChannel1) {
		this.refundChannel1 = refundChannel1;
	}

	public String getRefundChannel2() {
		return refundChannel2;
	}

	public void setRefundChannel2(String refundChannel2) {
		this.refundChannel2 = refundChannel2;
	}

	public String getRefundChannel3() {
		return refundChannel3;
	}

	public void setRefundChannel3(String refundChannel3) {
		this.refundChannel3 = refundChannel3;
	}

	public Integer getRefundFee0() {
		return refundFee0;
	}

	public void setRefundFee0(Integer refundFee0) {
		this.refundFee0 = refundFee0;
	}

	public Integer getRefundFee1() {
		return refundFee1;
	}

	public void setRefundFee1(Integer refundFee1) {
		this.refundFee1 = refundFee1;
	}

	public Integer getRefundFee2() {
		return refundFee2;
	}

	public void setRefundFee2(Integer refundFee2) {
		this.refundFee2 = refundFee2;
	}

	public Integer getRefundFee3() {
		return refundFee3;
	}

	public void setRefundFee3(Integer refundFee3) {
		this.refundFee3 = refundFee3;
	}

	public Integer getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	public Integer getCouponRefundFee() {
		return couponRefundFee;
	}

	public void setCouponRefundFee(Integer couponRefundFee) {
		this.couponRefundFee = couponRefundFee;
	}

	public Integer getSettlementRefundFee0() {
		return settlementRefundFee0;
	}

	public void setSettlementRefundFee0(Integer settlementRefundFee0) {
		this.settlementRefundFee0 = settlementRefundFee0;
	}

	public Integer getSettlementRefundFee1() {
		return settlementRefundFee1;
	}

	public void setSettlementRefundFee1(Integer settlementRefundFee1) {
		this.settlementRefundFee1 = settlementRefundFee1;
	}

	public Integer getSettlementRefundFee2() {
		return settlementRefundFee2;
	}

	public void setSettlementRefundFee2(Integer settlementRefundFee2) {
		this.settlementRefundFee2 = settlementRefundFee2;
	}

	public Integer getSettlementRefundFee3() {
		return settlementRefundFee3;
	}

	public void setSettlementRefundFee3(Integer settlementRefundFee3) {
		this.settlementRefundFee3 = settlementRefundFee3;
	}

	public Integer getCouponRefundFee0() {
		return couponRefundFee0;
	}

	public void setCouponRefundFee0(Integer couponRefundFee0) {
		this.couponRefundFee0 = couponRefundFee0;
	}

	public Integer getCouponRefundFee1() {
		return couponRefundFee1;
	}

	public void setCouponRefundFee1(Integer couponRefundFee1) {
		this.couponRefundFee1 = couponRefundFee1;
	}

	public Integer getCouponRefundFee2() {
		return couponRefundFee2;
	}

	public void setCouponRefundFee2(Integer couponRefundFee2) {
		this.couponRefundFee2 = couponRefundFee2;
	}

	public Integer getCouponRefundFee3() {
		return couponRefundFee3;
	}

	public void setCouponRefundFee3(Integer couponRefundFee3) {
		this.couponRefundFee3 = couponRefundFee3;
	}

	public String getCouponType0() {
		return couponType0;
	}

	public void setCouponType0(String couponType0) {
		this.couponType0 = couponType0;
	}

	public String getCouponType1() {
		return couponType1;
	}

	public void setCouponType1(String couponType1) {
		this.couponType1 = couponType1;
	}

	public String getCouponType2() {
		return couponType2;
	}

	public void setCouponType2(String couponType2) {
		this.couponType2 = couponType2;
	}

	public String getCouponType3() {
		return couponType3;
	}

	public void setCouponType3(String couponType3) {
		this.couponType3 = couponType3;
	}

	public Integer getCouponRefundCount0() {
		return couponRefundCount0;
	}

	public void setCouponRefundCount0(Integer couponRefundCount0) {
		this.couponRefundCount0 = couponRefundCount0;
	}

	public Integer getCouponRefundCount1() {
		return couponRefundCount1;
	}

	public void setCouponRefundCount1(Integer couponRefundCount1) {
		this.couponRefundCount1 = couponRefundCount1;
	}

	public Integer getCouponRefundCount2() {
		return couponRefundCount2;
	}

	public void setCouponRefundCount2(Integer couponRefundCount2) {
		this.couponRefundCount2 = couponRefundCount2;
	}

	public Integer getCouponRefundCount3() {
		return couponRefundCount3;
	}

	public void setCouponRefundCount3(Integer couponRefundCount3) {
		this.couponRefundCount3 = couponRefundCount3;
	}

	public String getRefundStatus0() {
		return refundStatus0;
	}

	public void setRefundStatus0(String refundStatus0) {
		this.refundStatus0 = refundStatus0;
	}

	public String getRefundStatus1() {
		return refundStatus1;
	}

	public void setRefundStatus1(String refundStatus1) {
		this.refundStatus1 = refundStatus1;
	}

	public String getRefundStatus2() {
		return refundStatus2;
	}

	public void setRefundStatus2(String refundStatus2) {
		this.refundStatus2 = refundStatus2;
	}

	public String getRefundStatus3() {
		return refundStatus3;
	}

	public void setRefundStatus3(String refundStatus3) {
		this.refundStatus3 = refundStatus3;
	}

	public String getRefundAccount0() {
		return refundAccount0;
	}

	public void setRefundAccount0(String refundAccount0) {
		this.refundAccount0 = refundAccount0;
	}

	public String getRefundAccount1() {
		return refundAccount1;
	}

	public void setRefundAccount1(String refundAccount1) {
		this.refundAccount1 = refundAccount1;
	}

	public String getRefundAccount2() {
		return refundAccount2;
	}

	public void setRefundAccount2(String refundAccount2) {
		this.refundAccount2 = refundAccount2;
	}

	public String getRefundAccount3() {
		return refundAccount3;
	}

	public void setRefundAccount3(String refundAccount3) {
		this.refundAccount3 = refundAccount3;
	}

	public String getRefundRecvAccount0() {
		return refundRecvAccount0;
	}

	public void setRefundRecvAccount0(String refundRecvAccount0) {
		this.refundRecvAccount0 = refundRecvAccount0;
	}

	public String getRefundRecvAccount1() {
		return refundRecvAccount1;
	}

	public void setRefundRecvAccount1(String refundRecvAccount1) {
		this.refundRecvAccount1 = refundRecvAccount1;
	}

	public String getRefundRecvAccount2() {
		return refundRecvAccount2;
	}

	public void setRefundRecvAccount2(String refundRecvAccount2) {
		this.refundRecvAccount2 = refundRecvAccount2;
	}

	public String getRefundRecvAccount3() {
		return refundRecvAccount3;
	}

	public void setRefundRecvAccount3(String refundRecvAccount3) {
		this.refundRecvAccount3 = refundRecvAccount3;
	}

	public String getRefundSuccessTime0() {
		return refundSuccessTime0;
	}

	public void setRefundSuccessTime0(String refundSuccessTime0) {
		this.refundSuccessTime0 = refundSuccessTime0;
	}

	public String getRefundSuccessTime1() {
		return refundSuccessTime1;
	}

	public void setRefundSuccessTime1(String refundSuccessTime1) {
		this.refundSuccessTime1 = refundSuccessTime1;
	}

	public String getRefundSuccessTime2() {
		return refundSuccessTime2;
	}

	public void setRefundSuccessTime2(String refundSuccessTime2) {
		this.refundSuccessTime2 = refundSuccessTime2;
	}

	public String getRefundSuccessTime3() {
		return refundSuccessTime3;
	}

	public void setRefundSuccessTime3(String refundSuccessTime3) {
		this.refundSuccessTime3 = refundSuccessTime3;
	}

	public Integer getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(Integer cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}
}
