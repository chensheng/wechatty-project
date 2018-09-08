package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.MediaType;

public class VoicePermanentMedia extends PermanentMedia {

	/**
	 * 
	 * @param media {@code size <= 2M}, {@code times <= 60s}, format: mp3/wma/wav/amr
	 */
	public VoicePermanentMedia(AppContext appContext, File media) {
		super(appContext, MediaType.VOICE, media);
	}

}
