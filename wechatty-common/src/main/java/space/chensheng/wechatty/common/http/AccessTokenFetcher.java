package space.chensheng.wechatty.common.http;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.JsonMapper;
import space.chensheng.wechatty.common.util.StringUtil;

public abstract class AccessTokenFetcher {
private static final Logger logger = LoggerFactory.getLogger(AccessTokenFetcher.class);
	
	private String getTokenUrl;
	
	private WechatContext wechatContext;
	
	private Semaphore updateSemaphore = new Semaphore(1);
	
	private AccessTokenStrategy accessTokenStrategy;
	
	
	/**
	 * 
	 * @param getTokenUrl
	 * @throws NullPointerException if getTokenUrl is null
	 */
	public AccessTokenFetcher(String getTokenUrl, WechatContext wechatContext) {
		if (StringUtil.isEmpty(getTokenUrl)) {
			throw new NullPointerException("getTokenUrl may not be null");
		}
		
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		this.getTokenUrl = getTokenUrl;
		this.wechatContext = wechatContext;
		this.initAccessTokenStrategy();
	}
	
	/**
	 * access_token should be updated every 2 hours, otherwise it will expire.
	 * Only one thread will really update access_token when multiple threads execute this method concurrently,
	 * Other threads will do nothing and return immediately without blocking.
	 */
	public void updateAccessToken() {
		if (!updateSemaphore.tryAcquire()) {
			logger.info("another thread is updating access token");
			return;
		}
		
		try {
			
			try {
				String responseStr = PoolingHttpUtil.get(getTokenUrl, wechatContext);
				AccessTokenResponse response = JsonMapper.nonEmptyMapper().fromJson(responseStr, AccessTokenResponse.class);
				if (response == null || StringUtil.isEmpty(response.getAccessToken())) {
					logger.error("fail to update access token, errcode: {}, errmsg: {}", 
							response !=null ? response.getErrcode() : "unknown",
							response != null ? response.getErrmsg() : "unknown");
				} else {
					this.setAccessToken(response.getAccessToken());
				}
				
			} catch (ClientProtocolException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			} catch (IOException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
			
		} finally {
			updateSemaphore.release();
		}
	}
	
	public String getAccessToken() {
		return accessTokenStrategy.doQuery();
	}
	
	public void updateIfNecessary(BaseResponse resp) {
		if (resp != null && resp.isAccessTokenError() && wechatContext.getAutoUpdateAccessToken()) {
			updateAccessToken();
		}
	}
	
	private void setAccessToken(String accessToken) {
		accessTokenStrategy.doSave(accessToken);
	}
	
	private void initAccessTokenStrategy() {
		String strategyClassName = wechatContext.getAccessTokenStrategyClass();
		Class<?> strategyClass = null;
		try {
			strategyClass = Class.forName(strategyClassName);
			if (!AccessTokenStrategy.class.isAssignableFrom(strategyClass)) {
				throw new IllegalArgumentException("Strategy class " + strategyClass + " is not a subclass of " + AccessTokenStrategy.class);
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Could not find strategy class " + strategyClassName);
		}
		
		try {
			accessTokenStrategy = (AccessTokenStrategy) strategyClass.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalArgumentException("Could not create instance of " + strategyClass + " with non-argument constructor");
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("Could not create instance of " + strategyClass + " with non-argument constructor");
		}
	}
}
