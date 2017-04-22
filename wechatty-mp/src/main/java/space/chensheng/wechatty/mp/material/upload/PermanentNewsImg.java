package space.chensheng.wechatty.mp.material.upload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import space.chensheng.wechatty.common.material.Material;
import space.chensheng.wechatty.common.material.MultiPartUploader;
import space.chensheng.wechatty.mp.util.MpAccessTokenFetcher;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class PermanentNewsImg extends Material {

	private File img;
	
	public PermanentNewsImg(File img) {
		super(MpWechatContext.getInstance(), MpAccessTokenFetcher.getInstance(), MultiPartUploader.getInstance(), "https://api.weixin.qq.com/cgi-bin/media/uploadimg");
		
		if (img == null) {
			throw new NullPointerException("img may not be null");
		}
		this.img = img;
	}
	
	@Override
	protected void addQueryParam(Map<String, String> queryParams) {
		queryParams.put("access_token", MpAccessTokenFetcher.getInstance().getAccessToken());
	}

	@Override
	protected Object createPostBody() {
		Map<String, Object> postBody = new HashMap<String, Object>();
		postBody.put("media", img);
		return postBody;
	}
}
