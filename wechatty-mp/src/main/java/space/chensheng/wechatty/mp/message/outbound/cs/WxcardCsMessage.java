package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class WxcardCsMessage extends CsOutboundMessage {
	@JsonProperty
	private Wxcard wxcard;
	
	@JsonProperty("customservice")
	private CustomerService customerService;
	
	public WxcardCsMessage() {
		super(MessageType.WXCARD);
		wxcard = new Wxcard();
	}
	
	public void setCardId(String cardId) {
		wxcard.cardId = cardId;
	}
	
	public void setKfAccount(String kfAccount) {
		customerService = new CustomerService();
		customerService.kfAccount = kfAccount;
	}
	
	private static class Wxcard {
		@JsonProperty("card_id")
		private String cardId;
	}

	private static class CustomerService {
		@JsonProperty("kf_account")
		private String kfAccount;
	}
}
