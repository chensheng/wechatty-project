package space.chensheng.wechatty.mp.message.outbound.mass;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.MassOutboundMessage;

public class TextMassMessage extends MassOutboundMessage {
	
	@JsonProperty
	private Text text;
	
	public TextMassMessage() {
		super(MessageType.TEXT);
		text = new Text();
	}
	
	public void setContent(String content) {
		text.content = content;
	}

	private static class Text {
		@JsonProperty
		private String content;
	}
}
