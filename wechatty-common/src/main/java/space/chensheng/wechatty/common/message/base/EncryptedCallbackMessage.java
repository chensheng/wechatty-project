package space.chensheng.wechatty.common.message.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class EncryptedCallbackMessage extends XmlMessage {
	
	@XStreamAlias("ToUserName")
	@XStreamCDATA
	protected String toUserName;
	
	@XStreamAlias("Encrypt")
	@XStreamCDATA
	protected String encrypt;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}
}
