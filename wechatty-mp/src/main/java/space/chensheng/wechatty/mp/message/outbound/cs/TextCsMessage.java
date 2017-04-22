package space.chensheng.wechatty.mp.message.outbound.cs;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class TextCsMessage extends CsOutboundMessage {
	
	@JsonProperty
	private Text text;
	
	public TextCsMessage() {
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
