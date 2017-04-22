package space.chensheng.wechatty.common.http;

public interface AccessTokenStrategy {
	/**
	 * save access token to memory, database or other medias
	 * @param accessToken
	 */
	void doSave(String accessToken);
	
	/**
	 * query access token from memory, database or other medias
	 * @return
	 */
	String doQuery();
}
