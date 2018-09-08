package space.chensheng.wechatty.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.util.ExceptionUtil;

public class WechatCallbackModeVerifier {
	private static final Logger logger = LoggerFactory.getLogger(WechatCallbackModeVerifier.class);
	
	private AppContext appContext;
	
	public WechatCallbackModeVerifier(AppContext appContext) {
		this.appContext = appContext;
	}
	
	public String verify(String msgSignature, String timestamp, String nonce, String echoStr) {
		if (!appContext.getWechatContext().getEnableCryptedMode()) {
			return echoStr;
		}
		

		try {
			return appContext.getWxBizMsgCrypt().VerifyURL(msgSignature, timestamp, nonce, echoStr);
		} catch (AesException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return "";
	}
}
