package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class UnifiedOrderRequest extends PayRequest {
	@XStreamAlias("appid")
	@XStreamCDATA
	private String appId;
	
	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;
	
	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr;
	
	@XStreamAlias("body")
	@XStreamCDATA
	private String body;
	
	@XStreamAlias("out_trade_no")
	@XStreamCDATA
	private String outTradeNo;
	
	@XStreamAlias("total_fee")
	@XStreamCDATA
	private Integer totalFee;
	
	@XStreamAlias("spbill_create_ip")
	@XStreamCDATA
	private String spbillCreateIp;
	
	@XStreamAlias("notify_url")
	@XStreamCDATA
	private String notifyUrl;
	
	@XStreamAlias("trade_type")
	@XStreamCDATA
	private String tradeType;
	
	@XStreamAlias("sign_type")
	@XStreamCDATA
	private String signType;
	
	@XStreamAlias("openid")
	@XStreamCDATA
	private String openId;
	
	@XStreamAlias("device_info")
	@XStreamCDATA
	private String deviceInfo;
	
	@XStreamAlias("detail")
	@XStreamCDATA
	private String detail;
	
	@XStreamAlias("attach")
	@XStreamCDATA
	private String attach;
	
	@XStreamAlias("fee_type")
	@XStreamCDATA
	private String feeType;

	@XStreamAlias("time_start")
	@XStreamCDATA
	private String timeStart;
	
	@XStreamAlias("time_expire")
	@XStreamCDATA
	private String timeExpire;
	
	@XStreamAlias("goods_tag")
	@XStreamCDATA
	private String goodsTag;
	
	@XStreamAlias("product_id")
	@XStreamCDATA
	private String productId;
	
	@XStreamAlias("limit_pay")
	@XStreamCDATA
	private String limitPay;
	
	@XStreamAlias("scene_info")
	@XStreamCDATA
	private String sceneInfo;
	
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

	public String getBody() {
		return body;
	}

	/**
	 * Required
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * Required
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	/**
	 * Required
	 * @param spbillCreateIp
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
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

	public String getTradeType() {
		return tradeType;
	}

	/**
	 * Required. Options are 'JSAPI', 'NATIVE' and 'APP'
	 * @param tradeType
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
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

	public String getOpenId() {
		return openId;
	}

	/**
	 * Required when tradeType is 'JSAPI'
	 * @param openId
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	/**
	 * 'WEB' is appropriate when paying in PC or MP
	 * @param deviceInfo
	 */
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getDetail() {
		return detail;
	}

	/**
	 * Goods description
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getFeeType() {
		return feeType;
	}

	/**
	 * Default is 'CNY'
	 * @param feeType
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getTimeStart() {
		return timeStart;
	}

	/**
	 * Format is 'yyyyMMddHHmmss'
	 * @param timeStart
	 */
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	/**
	 * Format is 'yyyyMMddHHmmss'
	 * @param timeExpire
	 */
	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	/**
	 * Default is 'WXG'
	 * @param goodsTag
	 */
	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getProductId() {
		return productId;
	}

	/**
	 * Required when tradeType is 'NATIVE'
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLimitPay() {
		return limitPay;
	}

	/**
	 * Default is 'no_credit'
	 * @param limitPay
	 */
	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getSceneInfo() {
		return sceneInfo;
	}

	/**
	 * A JSON format string.<br>
	 * {"store_info": {
	 *      "id": "SZTX001",
	 *      "name": "腾大餐厅",
	 *      "area_code": "440305",
	 *      "address": "科技园中一路腾讯大厦" 
	 *     }
	 * }
	 * @param sceneInfo
	 */
	public void setSceneInfo(String sceneInfo) {
		this.sceneInfo = sceneInfo;
	}
	
}
