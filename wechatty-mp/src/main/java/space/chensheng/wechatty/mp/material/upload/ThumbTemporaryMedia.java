package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.MediaType;

public class ThumbTemporaryMedia extends TemporaryMedia {

	/**
	 * 
	 * @param media {@code size <= 64KB}, format: jpg
	 */
	public ThumbTemporaryMedia(AppContext appContext, File media) {
		super(appContext, MediaType.THUMB, media);
	}

}
