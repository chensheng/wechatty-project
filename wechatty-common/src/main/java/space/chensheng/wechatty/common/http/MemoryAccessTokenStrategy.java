package space.chensheng.wechatty.common.http;

/**
 * 
 * @author sheng.chen
 * @date 2017-04-13
 * @Description: Strategy to save and query access token in memory
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
