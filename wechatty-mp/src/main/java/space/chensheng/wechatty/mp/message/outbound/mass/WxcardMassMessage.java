package space.chensheng.wechatty.mp.message.outbound.mass;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;

public class WxcardMassMessage extends MassOutboundMessage {
	@JsonProperty
	private Wxcard wxcard;
	
	public WxcardMassMessage() {
		super(MessageType.WXCARD);
		wxcard = new Wxcard();
	}
	
	public void setCardId(String cardId) {
		wxcard.cardId = cardId;
	}
	
	private static class Wxcard {
		@JsonProperty("card_id")
		private String cardId;
	}

}
