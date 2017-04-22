package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.security.WechatCallbackModeVerifier;

public class MpCallbackModeVerifier {
	public static String verify(String msgSignature, String timestamp, String nonce, String echoStr) {
		return WechatCallbackModeVerifier.verify(MpCrypterFactory.getCrypter(), MpWechatContext.getInstance(), msgSignature, timestamp, nonce, echoStr);
	}
}
