package space.chensheng.wechatty.mp.material.upload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.Material;
import space.chensheng.wechatty.common.material.MaterialUploader;

public class PermanentNewsImg extends Material {

	private File img;
	
	public PermanentNewsImg(AppContext appContext, File img) {
		super(appContext, "https://api.weixin.qq.com/cgi-bin/media/uploadimg");
		
		if (img == null) {
			throw new NullPointerException("img may not be null");
		}
		this.img = img;
	}
	
	@Override
	protected void addQueryParam(Map<String, String> queryParams) {
		queryParams.put("access_token", this.getAppContext().getAccessTokenFetcher().getAccessToken());
	}

	@Override
	protected Object createPostBody() {
		Map<String, Object> postBody = new HashMap<String, Object>();
		postBody.put("media", img);
		return postBody;
	}

	@Override
	protected MaterialUploader getUploader(AppContext appContext) {
		return appContext.getMultiPartUploader();
	}
}
