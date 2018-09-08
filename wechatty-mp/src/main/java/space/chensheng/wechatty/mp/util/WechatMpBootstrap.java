package space.chensheng.wechatty.mp.util;

import java.util.ArrayList;
import java.util.List;

import space.chensheng.wechatty.common.http.PoolingHttpUtil;
import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.material.MultiPartUploader;
import space.chensheng.wechatty.common.material.StringBodyUploader;
import space.chensheng.wechatty.common.message.MessageListener;
import space.chensheng.wechatty.common.security.WXBizMsgCrypt;
import space.chensheng.wechatty.common.security.WechatCallbackModeVerifier;
import space.chensheng.wechatty.common.util.StringUtil;
import space.chensheng.wechatty.mp.account.QRCodeCreator;
import space.chensheng.wechatty.mp.auth.AuthHelper;
import space.chensheng.wechatty.mp.jssdk.JsapiHelper;
import space.chensheng.wechatty.mp.material.MaterialDeleter;
import space.chensheng.wechatty.mp.material.MaterialFinder;
import space.chensheng.wechatty.mp.material.MaterialQuery;
import space.chensheng.wechatty.mp.menu.MenuHelper;
import space.chensheng.wechatty.mp.message.MpMessageDispatcher;
import space.chensheng.wechatty.mp.message.MpMessageSender;
import space.chensheng.wechatty.mp.pay.PayCertHttpCustomizer;
import space.chensheng.wechatty.mp.pay.PayHelper;
import space.chensheng.wechatty.mp.user.UserInfoQuery;

public class WechatMpBootstrap {
	private MpAppContext appContext;
	
	private String confFilePath;
	
	private MpWechatContextCustomizer wechatContextCustomizer;
	
	private PayCertHttpCustomizer payCertHttpCustomizer;
	
	private List<MessageListener<?>> msgListeners = new ArrayList<MessageListener<?>>();
	
	public WechatMpBootstrap() {
	}
	
	public WechatMpBootstrap(String confFilePath) {
		this.confFilePath = confFilePath;
	}
	
	public WechatMpBootstrap customizeWechatContext(MpWechatContextCustomizer customizer) {
		this.wechatContextCustomizer = customizer;
		return this;
	}
	
	public WechatMpBootstrap enablePayCert() {
		payCertHttpCustomizer = new PayCertHttpCustomizer();
		return this;
	}
	
	public WechatMpBootstrap addMsgListener(MessageListener<?> listener) {
		if (listener != null) {
			msgListeners.add(listener);
		}
		return this;
	}
	
	public MpAppContext build() {
		if (appContext != null) {
			return appContext;
		}
		
		appContext = new MpAppContext();
		
		MpWechatContext wechatContext = null;
		if (StringUtil.isNotEmpty(confFilePath)) {
			wechatContext = new MpWechatContext(confFilePath);
		} else {
			wechatContext = new MpWechatContext();
		}
		
		if (this.wechatContextCustomizer != null) {
			this.wechatContextCustomizer.customize(wechatContext);
		}
		appContext.setWechatContext(wechatContext);
		
		appContext.setHttpClientCustomizer(payCertHttpCustomizer);
		
		PoolingHttpUtil poolingHttpUtil = new PoolingHttpUtil(appContext);
		appContext.setPoolingHttpUtil(poolingHttpUtil);
		
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(wechatContext.getToken(), wechatContext.getAesKey(), wechatContext.getAppId());
		appContext.setWxBizMsgCrypt(wxBizMsgCrypt);
		
		WechatCallbackModeVerifier callbackModeVerifier = new WechatCallbackModeVerifier(appContext);
		appContext.setCallbackModeVerifier(callbackModeVerifier);
		
		MpAccessTokenFetcher accessTokenFetcher = new MpAccessTokenFetcher(appContext);
		appContext.setAccessTokenFetcher(accessTokenFetcher);
		
		WechatRequester wechatRequester = new WechatRequester(appContext);
		appContext.setWechatRequester(wechatRequester);
		
		MultiPartUploader multiPartUploader = new MultiPartUploader(appContext);
		appContext.setMultiPartUploader(multiPartUploader);
		
		StringBodyUploader stringBodyUploader = new StringBodyUploader(appContext);
		appContext.setStringBodyUploader(stringBodyUploader);
		
		MpMessageDispatcher mpMessageDispatcher = new MpMessageDispatcher(appContext, msgListeners);
		appContext.setMpMessageDispatcher(mpMessageDispatcher);
		
		MpMessageSender mpMessageSender = new MpMessageSender(appContext);
		appContext.setMpMessageSender(mpMessageSender);
		
		AuthHelper authHelper = new AuthHelper(appContext);
		appContext.setAuthHelper(authHelper);
		
		JsapiHelper jsapiHelper = new JsapiHelper(appContext);
		appContext.setJsapiHelper(jsapiHelper);
		
		MenuHelper menuHelper = new MenuHelper(appContext);
		appContext.setMenuHelper(menuHelper);
		
		MaterialDeleter materialDeleter = new MaterialDeleter(appContext);
		appContext.setMaterialDeleter(materialDeleter);
		
		MaterialFinder materialFinder = new MaterialFinder(appContext);
		appContext.setMaterialFinder(materialFinder);
		
		MaterialQuery materialQuery = new MaterialQuery(appContext);
		appContext.setMaterialQuery(materialQuery);
		
		QRCodeCreator qrCodeCreator = new QRCodeCreator(appContext);
		appContext.setQrCodeCreator(qrCodeCreator);
		
		UserInfoQuery userInfoQuery = new UserInfoQuery(appContext);
		appContext.setUserInfoQuery(userInfoQuery);
		
		PayHelper payHelper = new PayHelper(appContext);
		appContext.setPayHelper(payHelper);
		
		return appContext;
	}

}
