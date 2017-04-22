package space.chensheng.wechatty.common.material;

import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.util.StringUtil;

public class StringBodyUploader implements MaterialUploader {
    private static final StringBodyUploader instance = new StringBodyUploader();
    
    public static StringBodyUploader getInstance() {
    	return instance;
    }
    
    private StringBodyUploader() {
    	
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
		
		return WechatRequester.postString(uploadUrl, postString, UploadResponse.class, material.getWechatContext(), material.getAccessTokenFetcher());
	}

}
