package space.chensheng.wechatty.common.material;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.util.StringUtil;

public class StringBodyUploader implements MaterialUploader {
	private AppContext appContext;
    
    public StringBodyUploader(AppContext appContext) {
    	this.appContext = appContext;
    }
    
	public UploadResponse upload(Material material) {
		String uploadUrl = material.getUploadUrl();
		String query = material.generateQuery();
		if (StringUtil.isNotEmpty(query)) {
			uploadUrl += "?" + query;
		}
		
		Object postBody = material.createPostBody();
		String postString = null;
		if (postBody != null) {
			postString = String.valueOf(postBody);
		}
		
		return appContext.getWechatRequester().postString(uploadUrl, postString, UploadResponse.class);
	}

}
