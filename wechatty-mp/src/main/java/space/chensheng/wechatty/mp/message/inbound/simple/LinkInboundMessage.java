package space.chensheng.wechatty.mp.message.inbound.simple;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.SimpleInboundMessage;


public class LinkInboundMessage extends SimpleInboundMessage{

	@XStreamAlias("Title")
    @XStreamCDATA
	private String title;
	
	@XStreamAlias("Description")
    @XStreamCDATA
	private String description;
	
	@XStreamAlias("Url")
    @XStreamCDATA
	private String url;
	
	public LinkInboundMessage() {
		super(MessageType.LINK);
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

}
