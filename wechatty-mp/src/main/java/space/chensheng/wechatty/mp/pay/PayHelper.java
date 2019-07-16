package space.chensheng.wechatty.mp.pay;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.security.Aes256EcbCrypt;
import space.chensheng.wechatty.common.util.StringUtil;
import space.chensheng.wechatty.common.util.XmlUtil;
import space.chensheng.wechatty.mp.util.MpAppContext;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class PayHelper {
	private static final Logger logger = LoggerFactory.getLogger(PayHelper.class);
	
	private MpAppContext appContext;
	
	public PayHelper(MpAppContext appContext) {
		this.appContext = appContext;
	}
	
	/**
	 * Send simple red pack to user.
	 * @param mchBillNo not null, bill no of merchant
	 * @param sendName not null, then name of sender
	 * @param reOpenId not null, open id of receiver
	 * @param totalAmount not null, unit is FEN
	 * @param actName not null, activity name
	 * @param wishing not null
	 * @param remark not null
	 * @param sceneId
	 * @param consumeMchId
	 * @return
	 */
	public RedPackResponse sendRedPack(String mchBillNo, String sendName, 
			String reOpenId, int totalAmount, String actName, String wishing, 
			String remark, PayScene sceneId, String consumeMchId) {
		
		RedPackRequest request = new RedPackRequest();
		request.setMchBillNo(mchBillNo);
		request.setSendName(sendName);
		request.setReOpenId(reOpenId);
		request.setTotalAmount(totalAmount);
		request.setTotalNum(1);
		request.setActName(actName);
		request.setWishing(wishing);
		request.setRemark(remark);
		request.setSceneId(sceneId != null ? sceneId.toString() : null);
		request.setConsumeMchId(consumeMchId);
		
		return this.sendRedPack(request);
	}
	
	/**
	 * Send group red pack to user.
	 * @param mchBillNo not null, bill no of merchant
	 * @param sendName not null, the name of sender
	 * @param reOpenId not null, open id of receiver
	 * @param totalAmount not null, unit is FEN
	 * @param totalNum not null, number of receivers
	 * @param actName not null, activity name
	 * @param wishing not null
	 * @param remark not null
	 * @param sceneId
	 * @param consumeMchId
	 * @return
	 */
	public RedPackResponse sendGroupRedPack(String mchBillNo, String sendName, 
			String reOpenId, int totalAmount, int totalNum, String actName, 
			String wishing, String remark, PayScene sceneId, String consumeMchId) {
		GroupRedPackRequest request = new GroupRedPackRequest();
		request.setMchBillNo(mchBillNo);
		request.setSendName(sendName);
		request.setReOpenId(reOpenId);
		request.setTotalAmount(totalAmount);
		request.setTotalNum(totalNum);
		request.setAmtType("ALL_RAND");
		request.setActName(actName);
		request.setWishing(wishing);
		request.setRemark(remark);
		request.setSceneId(sceneId != null ? sceneId.toString() : null);
		request.setConsumeMchId(consumeMchId);
		
		return this.sendGroupRedPack(request);
	}
	
	/**
	 * Transfer money to user.
	 * @param partnerTradeNo not null
	 * @param openId not null, open id of receiver
	 * @param amount not null, unit is FEN
	 * @param desc not null
	 * @return
	 */
	public TransfersResponse transfers(String partnerTradeNo, String openId, int amount, String desc) {
		TransfersRequest request = new TransfersRequest();
		request.setPartnerTradeNo(partnerTradeNo);
		request.setOpenId(openId);
		request.setCheckName("NO_CHECK");
		request.setAmount(amount);
		request.setDesc(desc);
		
		return this.transfers(request);
	}
	
	/**
	 * Send red pack to user
	 * @param request
	 * @return
	 */
	public RedPackResponse sendRedPack(RedPackRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setNonceStr(StringUtil.getRandomStr());
		request.setMchId(wechatContext.getPayMchId());
		request.setWxAppId(wechatContext.getAppId());
		if (StringUtil.isEmpty(request.getClientIp())) {
			request.setClientIp(wechatContext.getPayClientIp());
		}

		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), RedPackResponse.class);
	}
	
	/**
	 * Send group red pack to user
	 * @param request
	 * @return
	 */
	public RedPackResponse sendGroupRedPack(GroupRedPackRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setNonceStr(StringUtil.getRandomStr());
		request.setMchId(wechatContext.getPayMchId());
		request.setWxAppId(wechatContext.getAppId());
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), RedPackResponse.class);
	}
	
	/**
	 * Transfer money to user
	 * @param request
	 * @return
	 */
	public TransfersResponse transfers(TransfersRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setMchAppId(wechatContext.getAppId());
		request.setMchId(wechatContext.getPayMchId());
		request.setNonceStr(StringUtil.getRandomStr());
		if (StringUtil.isEmpty(request.getSpbillCreateIp())) {
			request.setSpbillCreateIp(wechatContext.getPayClientIp());
		}
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), TransfersResponse.class);
	}
	
	/**
	 * Create a prepay unified order
	 * @param request
	 * @return
	 */
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setAppId(wechatContext.getAppId());
		request.setMchId(wechatContext.getPayMchId());
		request.setNonceStr(StringUtil.getRandomStr());
		if (StringUtil.isEmpty(request.getSpbillCreateIp())) {
			request.setSpbillCreateIp(wechatContext.getPayClientIp());
		}
		if (StringUtil.isEmpty(request.getNotifyUrl())) {
			request.setNotifyUrl(wechatContext.getPayNotifyUrl());
		}
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), UnifiedOrderResponse.class);
	}
	
	/**
	 * Create a prepay unified order
	 * @param body not null. Brief description about goods
	 * @param outTradeNo not null. Trade number of your system
	 * @param totalFee not null. Unit is FEN
	 * @param spbillCreateIp not null. IP of pay client
	 * @param tradeType not null
	 * @param openId required when tradeType is 'JSAPI'
	 * @return
	 */
	public UnifiedOrderResponse unifiedOrder(String body, String outTradeNo, int totalFee, 
			String spbillCreateIp, TradeType tradeType, String openId) {
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setBody(body);
		request.setOutTradeNo(outTradeNo);
		request.setTotalFee(totalFee);
		request.setSpbillCreateIp(spbillCreateIp);
		request.setTradeType(tradeType.toString());
		request.setOpenId(openId);
		return this.unifiedOrder(request);
	}
	
	/**
	 * Parse response content from notify URL set in unified order request
	 * @param notifyContent
	 * @return
	 */
	public PayNotifyResponse parsePayNotify(String notifyContent) {
		if (StringUtil.isEmpty(notifyContent)) {
			return null;
		}
		
		return XmlUtil.fromXML(notifyContent, PayNotifyResponse.class);
	}
	
	/**
	 * Parse response content from notify URL set in unified order request
	 * @param notifyStream
	 * @return
	 */
	public PayNotifyResponse parsePayNotify(InputStream notifyStream) {
		String notifyContent = StringUtil.readInputStream(notifyStream);
		return this.parsePayNotify(notifyContent);
	}
	
	/**
	 * Validate pay notify response by sign
	 * @param response
	 * @return success feedback if sign is correct, otherwise fail feedback.
	 */
	public PayNotifyFeedback validatePayNotify(PayNotifyResponse response) {
		if (response == null || StringUtil.isEmpty(response.getSign())) {
			return PayNotifyFeedback.FAIL;
		}
		
		String signToCheck = response.getSign();
		String sign = PaySignTool.sign(response, appContext);
		if (!signToCheck.equals(sign)) {
			return PayNotifyFeedback.FAIL;
		}
		
		return PayNotifyFeedback.SUCCESS;
	}
	
	/**
	 * Query order by transactionId or outTradeNo
	 * @param request
	 * @return
	 */
	public OrderQueryResponse orderQuery(OrderQueryRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setAppId(wechatContext.getAppId());
		request.setMchId(wechatContext.getPayMchId());
		request.setNonceStr(StringUtil.getRandomStr());
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/pay/orderquery";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), OrderQueryResponse.class);
	}
	
	/**
	 * Query order by transactionId or outTradeNo
	 * @param transactionId required when outTradeNo is null
	 * @param outTradeNo required when transactionId is null
	 * @return
	 */
	public OrderQueryResponse orderQuery(String transactionId, String outTradeNo) {
		OrderQueryRequest request = new OrderQueryRequest();
		request.setTransactionId(transactionId);
		request.setOutTradeNo(outTradeNo);
		return this.orderQuery(request);
	}
	
	/**
	 * Close order by outTradeNo
	 * @param request
	 * @return
	 */
	public CloseOrderResponse closeOrder(CloseOrderRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setAppId(wechatContext.getAppId());
		request.setMchId(wechatContext.getPayMchId());
		request.setNonceStr(StringUtil.getRandomStr());
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/pay/closeorder";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), CloseOrderResponse.class);
	}
	
	/**
	 * Close order by outTradeNo
	 * @param outTradeNo not null
	 * @return
	 */
	public CloseOrderResponse closeOrder(String outTradeNo) {
		CloseOrderRequest request = new CloseOrderRequest();
		request.setOutTradeNo(outTradeNo);
		return this.closeOrder(request);
	}
	
	/**
	 * Convert long url to short url
	 * @param longUrl
	 * @return
	 */
	public ShortUrlResponse shortUrl(String longUrl) {
		MpWechatContext wechatContext = getWechatContext();
		
		ShortUrlRequest request = new ShortUrlRequest();
		request.setAppId(wechatContext.getAppId());
		request.setMchId(wechatContext.getPayMchId());
		request.setNonceStr(StringUtil.getRandomStr());
		request.setLongUrl(longUrl);
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/tools/shorturl";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), ShortUrlResponse.class);
	}
	
	/**
	 * Generate pay parameters for 'JSAPI'
	 * @param prepayId not null
	 * @param signType default is 'SHA1'
	 * @return never null
	 */
	public JsapiPayParams generateJsapiPayParams(String prepayId, PaySignType signType) {
		JsapiPayParams params = new JsapiPayParams();
		if (StringUtil.isEmpty(prepayId)) {
			return params;
		}
		
		MpWechatContext wechatContext = getWechatContext();
		params.setAppId(wechatContext.getAppId());
		params.setNonceStr(StringUtil.getRandomStr());
		params.setPkg(String.format("prepay_id=%s", prepayId));
		params.setTimeStamp(String.valueOf(System.currentTimeMillis()/1000));
		params.setSignType(signType != null ? signType.toString() : PaySignType.SHA1.toString());
		String sign = PaySignTool.sign(params, appContext);
		params.setPaySign(sign);
	    return params;
	}
	
	/**
	 * Send a refund request
	 * @param request
	 * @return
	 */
	public RefundResponse refund(RefundRequest request) {
		MpWechatContext wechatContext = getWechatContext();
		
		request.setAppId(wechatContext.getAppId());
		request.setMchId(wechatContext.getPayMchId());
		request.setNonceStr(StringUtil.getRandomStr());

		if (StringUtil.isEmpty(request.getNotifyUrl())) {
			request.setNotifyUrl(wechatContext.getRefundNotifyUrl());
		}
		
		String sign = PaySignTool.sign(request, appContext);
		request.setSign(sign);
		
		String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		return appContext.getWechatRequester().postStringAndRespXml(url, request.toString(), RefundResponse.class);
	}
	
	/**
	 * Send a refund request
	 * @param outTradeNo not null
	 * @param outRefundNo not null
	 * @param totalFee not null
	 * @param refundFee not null
	 * @param refundDesc 
	 * @return
	 */
	public RefundResponse refund(String outTradeNo, String outRefundNo, int totalFee, int refundFee, String refundDesc) {
		RefundRequest request = new RefundRequest();
		request.setOutTradeNo(outTradeNo);
		request.setOutRefundNo(outRefundNo);
		request.setTotalFee(totalFee);
		request.setRefundFee(refundFee);
		request.setRefundDesc(refundDesc);
		return this.refund(request);
	}
	
	/**
	 * Parse refund notify
	 * @param notifyContent
	 * @return
	 */
	public RefundNotifyReqInfo parseRefundNotify(String notifyContent) {
		if (StringUtil.isEmpty(notifyContent)) {
			return null;
		}
		
		RefundNotifyResponse refundNotifyResp = XmlUtil.fromXML(notifyContent, RefundNotifyResponse.class);
		if (refundNotifyResp == null || StringUtil.isEmpty(refundNotifyResp.getReqInfo())) {
			logger.error("Fail to parse refund notify [{}]", notifyContent);
			return null;
		}
		
		MpWechatContext wechatContext = this.getWechatContext();
		String decryptedReqInfo = Aes256EcbCrypt.decrypt(wechatContext.getPayKey(), refundNotifyResp.getReqInfo());
		if (StringUtil.isEmpty(decryptedReqInfo)) {
			logger.error("Fail to dscrypt refund notify req_info [{}]", refundNotifyResp.getReqInfo());
			return null;
		}
		
		return XmlUtil.fromXML(decryptedReqInfo, RefundNotifyReqInfo.class);
	}
	
	/**
	 * Parse refund notify
	 * @param notifyStream
	 * @return
	 */
	public RefundNotifyReqInfo parseRefundNotify(InputStream notifyStream) {
		if (notifyStream == null) {
			return null;
		}
		
		return this.parseRefundNotify(StringUtil.readInputStream(notifyStream));
	}
	
	private MpWechatContext getWechatContext() {
		return (MpWechatContext) appContext.getWechatContext();
	}
	
}
