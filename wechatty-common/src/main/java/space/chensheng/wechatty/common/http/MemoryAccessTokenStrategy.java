package space.chensheng.wechatty.common.http;

/**
 * Strategy to save and query access token in memory
 * @author sheng.chen
 */
public class MemoryAccessTokenStrategy implements AccessTokenStrategy {
	private volatile String accessToken = "";
	
	public void doSave(String accessToken) {
		this.accessToken = accessToken;
	}

	public String doQuery() {
		return this.accessToken;
	}

}
