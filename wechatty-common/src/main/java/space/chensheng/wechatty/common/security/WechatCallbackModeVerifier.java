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

    /**
     * 验证服务器地址的有效性
     * 签名验证
     *
     * @param signature 微信服务器签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echoStr   随机字符串
     * @return
     */
	public String verify(String signature, String timestamp, String nonce, String echoStr) {
		if (!appContext.getWechatContext().getEnableCryptedMode()) {
			return echoStr;
		}


		try {
			return appContext.getWxBizMsgCrypt().VerifyURL(signature, timestamp, nonce, echoStr);
		} catch (AesException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}

		return "";
	}
}
