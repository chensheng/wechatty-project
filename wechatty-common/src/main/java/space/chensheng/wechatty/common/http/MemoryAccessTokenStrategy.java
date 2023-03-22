package space.chensheng.wechatty.common.http;

import space.chensheng.wechatty.common.conf.WechatContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Strategy to save and query access token in memory
 * @author sheng.chen
 */
public class MemoryAccessTokenStrategy implements AccessTokenStrategy {
	private static final String DEFAULT_CONTEXT_ID = "";

	private ConcurrentHashMap<String, String> accessTokenMap = new ConcurrentHashMap<String, String>();
	
	public void doSave(WechatContext wechatContext, String accessToken) {
		String contextId = doResolveContextId(wechatContext);
		accessTokenMap.put(contextId, accessToken);
	}

	public String doQuery(WechatContext wechatContext) {
		String contextId = doResolveContextId(wechatContext);
		return accessTokenMap.get(contextId);
	}

	private String doResolveContextId(WechatContext wechatContext) {
		String contextId = wechatContext.getContextId();
		if(contextId == null) {
			contextId = DEFAULT_CONTEXT_ID;
		}
		return contextId;
	}
}
