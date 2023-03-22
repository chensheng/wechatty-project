package space.chensheng.wechatty.common.http;

public interface AccessTokenFetcher {
	/**
	 * access_token should be updated every 2 hours, otherwise it will expire.
	 * Only one thread will really update access_token when multiple threads execute this method concurrently,
	 * Other threads will do nothing and return immediately without blocking.
	 */
	void updateAccessToken();
	
	String getAccessToken();
	
	void updateIfNecessary(Object resp);

	/**
	 * Update all access_token for all wechat accounts
	 */
	void batchUpdateAccessToken();
}
