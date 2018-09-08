package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.mp.account.QRCodeCreator;
import space.chensheng.wechatty.mp.auth.AuthHelper;
import space.chensheng.wechatty.mp.jssdk.JsapiHelper;
import space.chensheng.wechatty.mp.material.MaterialDeleter;
import space.chensheng.wechatty.mp.material.MaterialFinder;
import space.chensheng.wechatty.mp.material.MaterialQuery;
import space.chensheng.wechatty.mp.menu.MenuHelper;
import space.chensheng.wechatty.mp.message.MpMessageDispatcher;
import space.chensheng.wechatty.mp.message.MpMessageSender;
import space.chensheng.wechatty.mp.pay.PayHelper;
import space.chensheng.wechatty.mp.user.UserInfoQuery;

public class MpAppContext extends AppContext {
	private MpMessageDispatcher mpMessageDispatcher;
	
	private MpMessageSender mpMessageSender;
	
	private AuthHelper authHelper;
	
	private JsapiHelper jsapiHelper;
	
	private MenuHelper menuHelper;
	
	private PayHelper payHelper;
	
	private MaterialDeleter materialDeleter;
	
	private MaterialFinder materialFinder;
	
	private MaterialQuery materialQuery;
	
	private QRCodeCreator qrCodeCreator;
	
	private UserInfoQuery userInfoQuery;

	public MpMessageDispatcher getMpMessageDispatcher() {
		return mpMessageDispatcher;
	}

	public void setMpMessageDispatcher(MpMessageDispatcher mpMessageDispatcher) {
		this.mpMessageDispatcher = mpMessageDispatcher;
	}

	public MpMessageSender getMpMessageSender() {
		return mpMessageSender;
	}

	public void setMpMessageSender(MpMessageSender mpMessageSender) {
		this.mpMessageSender = mpMessageSender;
	}

	public AuthHelper getAuthHelper() {
		return authHelper;
	}

	public void setAuthHelper(AuthHelper authHelper) {
		this.authHelper = authHelper;
	}

	public JsapiHelper getJsapiHelper() {
		return jsapiHelper;
	}

	public void setJsapiHelper(JsapiHelper jsapiHelper) {
		this.jsapiHelper = jsapiHelper;
	}

	public MenuHelper getMenuHelper() {
		return menuHelper;
	}

	public void setMenuHelper(MenuHelper menuHelper) {
		this.menuHelper = menuHelper;
	}

	public PayHelper getPayHelper() {
		return payHelper;
	}

	public void setPayHelper(PayHelper payHelper) {
		this.payHelper = payHelper;
	}

	public MaterialDeleter getMaterialDeleter() {
		return materialDeleter;
	}

	public void setMaterialDeleter(MaterialDeleter materialDeleter) {
		this.materialDeleter = materialDeleter;
	}

	public MaterialFinder getMaterialFinder() {
		return materialFinder;
	}

	public void setMaterialFinder(MaterialFinder materialFinder) {
		this.materialFinder = materialFinder;
	}

	public MaterialQuery getMaterialQuery() {
		return materialQuery;
	}

	public void setMaterialQuery(MaterialQuery materialQuery) {
		this.materialQuery = materialQuery;
	}
	
	public QRCodeCreator getQrCodeCreator() {
		return qrCodeCreator;
	}

	public void setQrCodeCreator(QRCodeCreator qrCodeCreator) {
		this.qrCodeCreator = qrCodeCreator;
	}

	public UserInfoQuery getUserInfoQuery() {
		return userInfoQuery;
	}

	public void setUserInfoQuery(UserInfoQuery userInfoQuery) {
		this.userInfoQuery = userInfoQuery;
	}
}
