package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.material.MediaType;

public class VoicePermanentMedia extends PermanentMedia {

	/**
	 * 
	 * @param media {@code size <= 2M}, {@code times <= 60s}, format: mp3/wma/wav/amr
	 */
	public VoicePermanentMedia(File media) {
		super(MediaType.VOICE, media);
	}

}
