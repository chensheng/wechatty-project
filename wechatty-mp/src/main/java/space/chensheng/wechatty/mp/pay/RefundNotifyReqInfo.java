package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

@XStreamAlias("root")
public class RefundNotifyReqInfo {
	@XStreamAlias("transaction_id")
	@XStreamCDATA
	private String transactionId;
	
	@XStreamAlias("out_trade_no")
	@XStreamCDATA
	private String outTradeNo;
	
	@XStreamAlias("refund_id")
	@XStreamCDATA
	private String refundId;
	
	@XStreamAlias("out_refund_no")
	@XStreamCDATA
	private String outRefundNo;
	
	@XStreamAlias("total_fee")
	@XStreamCDATA
	private Integer totalFee;
	
	@XStreamAlias("settlement_total_fee")
	@XStreamCDATA
	private Integer settlementTotalFee;
	
	@XStreamAlias("refund_fee")
	@XStreamCDATA
	private Integer refundFee;
	
	@XStreamAlias("settlement_refund_fee")
	@XStreamCDATA
	private Integer settlementRefundFee;
	
	@XStreamAlias("refund_status")
	@XStreamCDATA
	private String refundStatus;
	
	@XStreamAlias("success_time")
	@XStreamCDATA
	private String successTime;
	
	@XStreamAlias("refund_recv_accout")
	@XStreamCDATA
	private String refundRecvAccout;
	
	@XStreamAlias("refund_account")
	@XStreamCDATA
	private String refundAccount;
	
	@XStreamAlias("refund_request_source")
	@XStreamCDATA
	private String refundRequestSource;

	@XStreamAlias("cash_refund_fee")
	@XStreamCDATA
	private Integer cashRefundFee;

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

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
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

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(String successTime) {
		this.successTime = successTime;
	}

	public String getRefundRecvAccout() {
		return refundRecvAccout;
	}

	public void setRefundRecvAccout(String refundRecvAccout) {
		this.refundRecvAccout = refundRecvAccout;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public String getRefundRequestSource() {
		return refundRequestSource;
	}

	public void setRefundRequestSource(String refundRequestSource) {
		this.refundRequestSource = refundRequestSource;
	}
	
	public boolean isRefundSuccess() {
		return "SUCCESS".equals(refundStatus);
	}

	public Integer getCashRefundFee() {
		return cashRefundFee;
	}

	public void setCashRefundFee(Integer cashRefundFee) {
		this.cashRefundFee = cashRefundFee;
	}
}
