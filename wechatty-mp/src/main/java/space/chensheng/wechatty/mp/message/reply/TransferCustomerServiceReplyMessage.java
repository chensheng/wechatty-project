package space.chensheng.wechatty.mp.message.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class TransferCustomerServiceReplyMessage extends ReplyMessage {
	@XStreamAlias("TransInfo")
	private TransInfo transInfo;

	public TransferCustomerServiceReplyMessage() {
		super(MessageType.TRANSFER_CUSTOMER_SERVICE);
	}
	
	public TransInfo getTransInfo() {
		return transInfo;
	}

	public void setTransInfo(TransInfo transInfo) {
		this.transInfo = transInfo;
	}
	
	public void setKfAccount(String kfAccount) {
		transInfo = new TransInfo();
		transInfo.setKfAccount(kfAccount);
	}

	private static class TransInfo extends XmlMessage {
		@XStreamAlias("KfAccount")
	    @XStreamCDATA
		private String kfAccount;

		@SuppressWarnings("unused")
		public String getKfAccount() {
			return kfAccount;
		}

		public void setKfAccount(String kfAccount) {
			this.kfAccount = kfAccount;
		}
		
	}
}
