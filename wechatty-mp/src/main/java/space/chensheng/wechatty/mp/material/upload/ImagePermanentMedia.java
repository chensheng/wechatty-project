package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.material.MediaType;

public class ImagePermanentMedia extends PermanentMedia {

	/**
	 * 
	 * @param media {@code size <= 2M}, format: bmp|png|jpeg|jpg|gif
	 */
	public ImagePermanentMedia(File media) {
		super(MediaType.IMAGE, media);
	}

}
