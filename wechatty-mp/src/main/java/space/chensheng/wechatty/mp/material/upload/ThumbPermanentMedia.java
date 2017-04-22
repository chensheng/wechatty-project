package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.material.MediaType;

public class ThumbPermanentMedia extends PermanentMedia {

	/**
	 * 
	 * @param media {@code size <= 64KB}, format: jpg
	 */
	public ThumbPermanentMedia(File media) {
		super(MediaType.THUMB, media);
	}

}
