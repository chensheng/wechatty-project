package space.chensheng.wechatty.mp.material.upload;

import java.io.File;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.MaterialUploader;
import space.chensheng.wechatty.common.material.MediaType;

public class ImagePermanentMedia extends PermanentMedia {

	/**
	 * 
	 * @param media {@code size <= 2M}, format: bmp|png|jpeg|jpg|gif
	 */
	public ImagePermanentMedia(AppContext appContext, File media) {
		super(appContext, MediaType.IMAGE, media);
	}

	@Override
	protected MaterialUploader getUploader(AppContext appContext) {
		return appContext.getMultiPartUploader();
	}

}
