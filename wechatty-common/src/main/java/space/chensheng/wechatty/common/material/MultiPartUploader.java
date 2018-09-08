package space.chensheng.wechatty.common.material;

import java.util.Map;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.util.StringUtil;

public class MultiPartUploader implements MaterialUploader {
	private AppContext appContext;
    
    public MultiPartUploader(AppContext appContext) {
    	this.appContext = appContext;
    }
    
	@SuppressWarnings("unchecked")
	public UploadResponse upload(Material material) {
		String uploadUrl = material.getUploadUrl();
		String query = material.generateQuery();
		if (StringUtil.isNotEmpty(query)) {
			uploadUrl += "?" + query;
		}
		
		Object postBody = material.createPostBody();
		Map<String, Object> params = null;
		if (postBody instanceof Map) {
			params = (Map<String, Object>) postBody;
		}
		
		return appContext.getWechatRequester().postMultipart(uploadUrl, params, UploadResponse.class);
	}

}
