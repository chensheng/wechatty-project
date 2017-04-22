package space.chensheng.wechatty.mp.message.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class TextReplyMessage extends ReplyMessage {
	
	@XStreamAlias("Content")
    @XStreamCDATA
	protected String content;
	
	public TextReplyMessage() {
		super(MessageType.TEXT);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
