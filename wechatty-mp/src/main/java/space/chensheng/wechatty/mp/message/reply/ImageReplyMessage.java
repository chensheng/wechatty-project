package space.chensheng.wechatty.mp.message.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class ImageReplyMessage extends ReplyMessage {

	@XStreamAlias("Image")
	protected ImageItem imageItem;
	
	public ImageReplyMessage() {
		super(MessageType.IMAGE);
		imageItem = new ImageItem();
	}

	public String getMediaId() {
		return imageItem.getMediaId();
	}


	public void setMediaID(String mediaId) {
		imageItem.setMediaId(mediaId);
	}
	
	private static class ImageItem extends XmlMessage {
		
		@XStreamAlias("MediaId")
	    @XStreamCDATA
		protected String mediaId;
		
		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
