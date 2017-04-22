package space.chensheng.wechatty.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.util.ExceptionUtil;

public class WechatCallbackModeVerifier {
	private static final Logger logger = LoggerFactory.getLogger(WechatCallbackModeVerifier.class);
	
	public static String verify(WXBizMsgCrypt crypter, WechatContext wechatContext, String msgSignature, String timestamp, String nonce, String echoStr) {
		if (wechatContext != null && !wechatContext.getEnableCryptedMode()) {
			return echoStr;
		}
		
		if (crypter != null) {
			try {
				return crypter.VerifyURL(msgSignature, timestamp, nonce, echoStr);
			} catch (AesException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
		
		return "";
	}
}
