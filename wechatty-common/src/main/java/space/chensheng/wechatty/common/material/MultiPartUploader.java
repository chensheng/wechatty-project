package space.chensheng.wechatty.common.material;

import java.util.Map;

import space.chensheng.wechatty.common.http.WechatRequester;
import space.chensheng.wechatty.common.util.StringUtil;

public class MultiPartUploader implements MaterialUploader {
	
    private static final MultiPartUploader instance = new MultiPartUploader();
    
    public static MultiPartUploader getInstance() {
    	return instance;
    }
    
    private MultiPartUploader() {
    	
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
		
		return WechatRequester.postMultipart(uploadUrl, params, UploadResponse.class, material.getWechatContext(), material.getAccessTokenFetcher());
	}

}
