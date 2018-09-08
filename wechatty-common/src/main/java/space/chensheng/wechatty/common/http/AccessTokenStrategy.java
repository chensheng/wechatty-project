package space.chensheng.wechatty.common.http;

public interface AccessTokenStrategy {
	/**
	 * save access token to memory, database or other medias
	 * @param accessToken access token of wechat
	 */
	void doSave(String accessToken);
	
	/**
	 * query access token from memory, database or other medias
	 * @return access token of wechat
	 */
	String doQuery();
}
