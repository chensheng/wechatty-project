package space.chensheng.wechatty.common.conf;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.http.MemoryAccessTokenStrategy;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.StringUtil;


public abstract class WechatContext {
	private static final Logger logger = LoggerFactory.getLogger(WechatContext.class);
	
	private int poolingHttpMaxPerRoute;
	
	private int poolingHttpMaxTotal;
	
	private int poolingHttpSocketTimeoutMillis;
	
	private int poolingHttpConnectTimeoutMillis;
	
	private int poolingHttpConnectionRequestTimeoutMillis;
	
	private boolean poolingHttpTcpNoDelay;
	
	private boolean poolingHttpProxyEnable;
	
	private String poolingHttpProxyHostname;

	private Integer poolingHttpProxyPort;
	
	private String poolingHttpProxyUsername;
	
	private String poolingHttpProxyPassword;
	
	
	/**
	 * The full name of strategy class to save and query access_token, default is {@link MemoryAccessTokenStrategy}
	 */
	@PropOption(notNull = true)
	private String accessTokenStrategyClass;

	/**
	 * Whether to update access token automatically when fail to execute wechat request because of expired access token.
	 * Default is false, mean to call {@code AccessTokenFetcher#updateAccessToken()} method manually.
	 */
	private boolean autoUpdateAccessToken;
	
	private boolean enableCryptedMode;
	
	public WechatContext(String defaultConfPath, String customerConfPath) {
		if (defaultConfPath != null) {
			loadContext(defaultConfPath);
		}
		
		if (customerConfPath != null) {
			loadContext(customerConfPath);
		}
		
		checkNotNull(WechatContext.class);
		checkNotNull(getClass());
	}
	
	protected void loadContext(String confPath) {
		Properties props = new Properties();
		InputStream propsIs = null;
		try {
			propsIs = this.getClass().getResourceAsStream(confPath);
			if(propsIs == null) {
				throw new NullPointerException("config file " + confPath + " not found!!!");
			}
			props.load(propsIs);
			fillFields(props, WechatContext.class);
			fillFields(props, getClass());
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} finally {
			if(propsIs != null) {
				try {
					propsIs.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
		}
	}
	
	private void fillFields(Properties props, Class<?> clzz) {
		Field[] fields = clzz.getDeclaredFields();
		for(Field field : fields) {
			if(Modifier.isStatic(field.getModifiers())){
				continue;
			}
			
			field.setAccessible(true);
			PropOption propOption = field.getAnnotation(PropOption.class);
			
			if (propOption != null && propOption.ignore()) {
				continue;
			}
			
			String fieldName = field.getName();
			String propKey = fieldName;
			String propVal = props.getProperty(propKey);
			if(propVal == null){
				continue;
			}
			
			Class<?> fieldType = field.getType();
			Object fieldVal = null;
			
			if(fieldType == Integer.class || fieldType == int.class) {
				fieldVal = StringUtil.parseToInt(propVal, 0);
			} else if(fieldType == Long.class || fieldType == long.class) {
				fieldVal = StringUtil.parseToLong(propVal, 0);
			} else if(fieldType == Boolean.class || fieldType == boolean.class) {
				fieldVal = Boolean.valueOf(propVal);
			} else if(fieldType == String.class) {
				fieldVal = propVal;
			} else {
				continue;
			}
			
			try {
				field.set(this, fieldVal);
			} catch (IllegalArgumentException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			} catch (IllegalAccessException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
	}
	
	private void checkNotNull(Class<?> clzz) {
		Field[] fields = clzz.getDeclaredFields();
		for(Field field : fields) {
			if(Modifier.isStatic(field.getModifiers())){
				continue;
			}
			
			field.setAccessible(true);
			PropOption propOption = field.getAnnotation(PropOption.class);
			
			if (propOption != null && propOption.notNull()) {
				try {
					if (field.get(this) == null) {
						throw new NullPointerException(field.getName() + " may not be null");
					}
				} catch (IllegalArgumentException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				} catch (IllegalAccessException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
		}
	}

	public int getPoolingHttpMaxPerRoute() {
		return poolingHttpMaxPerRoute;
	}

	public void setPoolingHttpMaxPerRoute(int poolingHttpMaxPerRoute) {
		this.poolingHttpMaxPerRoute = poolingHttpMaxPerRoute;
	}

	public int getPoolingHttpMaxTotal() {
		return poolingHttpMaxTotal;
	}

	public void setPoolingHttpMaxTotal(int poolingHttpMaxTotal) {
		this.poolingHttpMaxTotal = poolingHttpMaxTotal;
	}

	public boolean isPoolingHttpTcpNoDelay() {
		return poolingHttpTcpNoDelay;
	}

	public void setPoolingHttpTcpNoDelay(boolean poolingHttpTcpNoDelay) {
		this.poolingHttpTcpNoDelay = poolingHttpTcpNoDelay;
	}

	public int getPoolingHttpSocketTimeoutMillis() {
		return poolingHttpSocketTimeoutMillis;
	}

	public void setPoolingHttpSocketTimeoutMillis(int poolingHttpSocketTimeoutMillis) {
		this.poolingHttpSocketTimeoutMillis = poolingHttpSocketTimeoutMillis;
	}

	public int getPoolingHttpConnectTimeoutMillis() {
		return poolingHttpConnectTimeoutMillis;
	}

	public void setPoolingHttpConnectTimeoutMillis(int poolingHttpConnectTimeoutMillis) {
		this.poolingHttpConnectTimeoutMillis = poolingHttpConnectTimeoutMillis;
	}

	public int getPoolingHttpConnectionRequestTimeoutMillis() {
		return poolingHttpConnectionRequestTimeoutMillis;
	}

	public void setPoolingHttpConnectionRequestTimeoutMillis(int poolingHttpConnectionRequestTimeoutMillis) {
		this.poolingHttpConnectionRequestTimeoutMillis = poolingHttpConnectionRequestTimeoutMillis;
	}

	public boolean getAutoUpdateAccessToken() {
		return autoUpdateAccessToken;
	}

	public void setAutoUpdateAccessToken(boolean autoUpdateAccessToken) {
		this.autoUpdateAccessToken = autoUpdateAccessToken;
	}

	public boolean getEnableCryptedMode() {
		return enableCryptedMode;
	}

	public void setEnableCryptedMode(boolean enableCryptedMode) {
		this.enableCryptedMode = enableCryptedMode;
	}
	
	public boolean isPoolingHttpProxyEnable() {
		return poolingHttpProxyEnable;
	}

	public void setPoolingHttpProxyEnable(boolean poolingHttpProxyEnable) {
		this.poolingHttpProxyEnable = poolingHttpProxyEnable;
	}

	public Integer getPoolingHttpProxyPort() {
		return poolingHttpProxyPort;
	}

	public void setPoolingHttpProxyPort(Integer poolingHttpProxyPort) {
		this.poolingHttpProxyPort = poolingHttpProxyPort;
	}

	public String getPoolingHttpProxyHostname() {
		return poolingHttpProxyHostname;
	}

	public void setPoolingHttpProxyHostname(String poolingHttpProxyHostname) {
		this.poolingHttpProxyHostname = poolingHttpProxyHostname;
	}

	public String getPoolingHttpProxyUsername() {
		return poolingHttpProxyUsername;
	}

	public void setPoolingHttpProxyUsername(String poolingHttpProxyUsername) {
		this.poolingHttpProxyUsername = poolingHttpProxyUsername;
	}

	public String getPoolingHttpProxyPassword() {
		return poolingHttpProxyPassword;
	}

	public void setPoolingHttpProxyPassword(String poolingHttpProxyPassword) {
		this.poolingHttpProxyPassword = poolingHttpProxyPassword;
	}
	
	public String getAccessTokenStrategyClass() {
		return accessTokenStrategyClass;
	}

	public void setAccessTokenStrategyClass(String accessTokenStrategyClass) {
		this.accessTokenStrategyClass = accessTokenStrategyClass;
	}
}
