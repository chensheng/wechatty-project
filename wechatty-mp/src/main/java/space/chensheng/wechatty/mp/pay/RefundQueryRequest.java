package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import space.chensheng.wechatty.common.util.XmlUtil;

public class RefundQueryRequest extends PayRequest {
    @XStreamAlias("appid")
    @XmlUtil.XStreamCDATA
    private String appId;

    @XStreamAlias("mch_id")
    @XmlUtil.XStreamCDATA
    private String mchId;

    @XStreamAlias("nonce_str")
    @XmlUtil.XStreamCDATA
    private String nonceStr;

    @XStreamAlias("sign_type")
    @XmlUtil.XStreamCDATA
    private String signType;

    @XStreamAlias("transaction_id")
    @XmlUtil.XStreamCDATA
    private String transactionId;

    @XStreamAlias("out_trade_no")
    @XmlUtil.XStreamCDATA
    private String outTradeNo;

    @XStreamAlias("out_refund_no")
    @XmlUtil.XStreamCDATA
    private String outRefundNo;

    @XStreamAlias("refund_id")
    @XmlUtil.XStreamCDATA
    private String refundId;

    @XStreamAlias("offset")
    @XmlUtil.XStreamCDATA
    private Integer offset;

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

    public String getTransactionId() {
        return transactionId;
    }

    /**
     * One of transactionId/outTradeNo/outRefundNo/refundId is required
     * @param transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * One of transactionId/outTradeNo/outRefundNo/refundId is required
     * @param outTradeNo
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * One of transactionId/outTradeNo/outRefundNo/refundId is required
     * @param outRefundNo
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    /**
     * One of transactionId/outTradeNo/outRefundNo/refundId is required
     * @param refundId
     */
    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
