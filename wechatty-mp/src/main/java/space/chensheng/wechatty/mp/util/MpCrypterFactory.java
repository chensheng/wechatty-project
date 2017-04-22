package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.security.WXBizMsgCrypt;

public class MpCrypterFactory {
	
	private static final WXBizMsgCrypt crypter;
	
	static {
		crypter = new WXBizMsgCrypt(MpWechatContext.getInstance().getToken(), 
				MpWechatContext.getInstance().getAesKey(), MpWechatContext.getInstance().getAppId());
	}
	
	public static WXBizMsgCrypt getCrypter() {
		return crypter;
	}
}
