package space.chensheng.wechatty.common.message.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class EncryptedReplyMessage extends XmlMessage {
	
	public static final EncryptedReplyMessage EMPTY_MSG = new EncryptedReplyMessage();

	@XStreamAlias("MsgSignature")
	@XStreamCDATA
	protected String msgSignature;
	
	@XStreamAlias("TimeStamp")
	protected Long timeStamp;
	
	@XStreamAlias("Nonce")
	@XStreamCDATA
	protected Long nonce;
	
	@XStreamAlias("Encrypt")
	@XStreamCDATA
	protected String encrypt;

	public String getMsgSignature() {
		return msgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getNonce() {
		return nonce;
	}

	public void setNonce(Long nonce) {
		this.nonce = nonce;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

}
