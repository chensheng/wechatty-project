package space.chensheng.wechatty.mp.message.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class VideoReplyMessage extends ReplyMessage {

	@XStreamAlias("Video")
	protected VideoItem videoItem;
	
	public VideoReplyMessage() {
		super(MessageType.VIDEO);
		videoItem = new VideoItem();
	}

	public String getMediaId() {
		return videoItem.getMediaId();
	}

	public void setMediaId(String mediaId) {
		videoItem.setMediaId(mediaId);
	}
	
	public String getTitle() {
		return videoItem.getTitle();
	}
	
	public void setTitle(String title) {
		videoItem.setTitle(title);
	}
	
	public String getDescription() {
		return videoItem.getDescription();
	}
	
	public void setDescription(String description) {
		videoItem.setDescription(description);
	}
	
	private static class VideoItem extends XmlMessage {
		
		@XStreamAlias("MediaId")
	    @XStreamCDATA
		protected String mediaId;
		
		@XStreamAlias("Title")
	    @XStreamCDATA
		protected String title;
		
		@XStreamAlias("Description")
	    @XStreamCDATA
		protected String description;
		
		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}
}
