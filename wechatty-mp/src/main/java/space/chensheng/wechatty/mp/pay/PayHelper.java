package space.chensheng.wechatty.mp.pay;

import space.chensheng.wechatty.common.util.StringUtil;
import space.chensheng.wechatty.mp.util.MpAppContext;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class PayHelper {
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
	
	private MpWechatContext getWechatContext() {
		return (MpWechatContext) appContext.getWechatContext();
	}
}
