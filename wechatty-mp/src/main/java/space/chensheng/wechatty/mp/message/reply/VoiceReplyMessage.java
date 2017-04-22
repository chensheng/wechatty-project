package space.chensheng.wechatty.mp.message.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class VoiceReplyMessage extends ReplyMessage {

	@XStreamAlias("Voice")
	protected VoiceItem voiceItem;
	
	public VoiceReplyMessage() {
		super(MessageType.VOICE);
		voiceItem = new VoiceItem();
	}

	public String getMediaId() {
		return voiceItem.getMediaId();
	}

	public void setMediaId(String mediaId) {
		voiceItem.setMediaId(mediaId);
	}
	
	private static class VoiceItem extends XmlMessage {
		
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
