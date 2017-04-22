package space.chensheng.wechatty.mp.message.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class MusicReplyMessage extends ReplyMessage {

	@XStreamAlias("Music")
	protected MusicItem musicItem;
	
	public MusicReplyMessage() {
		super(MessageType.MUSIC);
		musicItem = new MusicItem();
	}

	public String getThumbMediaId() {
		return musicItem.thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		musicItem.thumbMediaId = thumbMediaId;
	}
	
	public void setTitle(String title) {
		musicItem.title = title;
	}
	
	public void setDescription(String description) {
		musicItem.description = description;
	}
	
	public void setMusicUrl(String musicUrl) {
		musicItem.musicUrl = musicUrl;
	}
	
	public void setHqMusicUrl(String hqMusicUrl) {
		musicItem.hqMusicUrl = hqMusicUrl;
	}
	
	private static class MusicItem extends XmlMessage {
		
		@XStreamAlias("ThumbMediaId")
	    @XStreamCDATA
		protected String thumbMediaId;
		
		@XStreamAlias("Title")
	    @XStreamCDATA
		protected String title;
		
		@XStreamAlias("Description")
	    @XStreamCDATA
		protected String description;
		
		@XStreamAlias("MusicURL")
	    @XStreamCDATA
		protected String musicUrl;
		
		@XStreamAlias("HQMusicUrl")
	    @XStreamCDATA
		protected String hqMusicUrl;
	}
}
