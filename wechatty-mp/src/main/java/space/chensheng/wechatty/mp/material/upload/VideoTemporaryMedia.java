package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.MediaType;

public class VideoTemporaryMedia extends TemporaryMedia {

	/**
	 * 
	 * @param media {@code size <= 10M},  format: mp4
	 */
	public VideoTemporaryMedia(AppContext appContext, File media) {
		super(appContext, MediaType.VIDEO, media);
	}

}
