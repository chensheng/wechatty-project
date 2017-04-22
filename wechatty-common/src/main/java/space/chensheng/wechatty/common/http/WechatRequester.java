package space.chensheng.wechatty.common.http;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.JsonMapper;

public class WechatRequester {
	private static final Logger logger = LoggerFactory.getLogger(WechatRequester.class);
	
	/**
	 * 
	 * @param url
	 * @param retClzz
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @return null if network error
	 * @throws NullPointerException if any argument is null
	 */
	public static <T extends BaseResponse> T get(String url, Class<T> retClzz, 
			WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = PoolingHttpUtil.get(url, wechatContext);
			if (responseStr != null) {
				responseStr = new String(responseStr.getBytes("ISO-8859-1"), "UTF-8");
			}
			response = JsonMapper.nonEmptyMapper().fromJson(responseStr, retClzz);
			accessTokenFetcher.updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url
	 * @param postString
	 * @param retClzz
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @return null if network error
	 * @throws NullPointerException if any argument except {@code postString} is null
	 */
	public static <T extends BaseResponse> T postString(String url, String postString, Class<T> retClzz, 
			WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = PoolingHttpUtil.postString(url, postString, wechatContext);
			if (responseStr != null) {
				responseStr = new String(responseStr.getBytes("ISO-8859-1"), "UTF-8");
			}
			response = JsonMapper.nonEmptyMapper().fromJson(responseStr, retClzz);
			accessTokenFetcher.updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url
	 * @param postData
	 * @param retClzz
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @return null if network error
	 * @throws NullPointerException if any argument except {@code postData} is null
	 */
	public static <T extends BaseResponse> T postMultipart(String url, Map<String, Object> postData, Class<T> retClzz, 
			WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = PoolingHttpUtil.postMultipart(url, postData, wechatContext);
			if (responseStr != null) {
				responseStr = new String(responseStr.getBytes("ISO-8859-1"), "UTF-8");
			}
			response = JsonMapper.nonEmptyMapper().fromJson(responseStr, retClzz);
			accessTokenFetcher.updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url
	 * @param postString
	 * @param downloadDir
	 * @param fileName
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @return null if network error
	 * @throws NullPointerException if url, downloadDir , wecahtContext, accessTokenFetcher is null
	 */
	public static DownloadResponse downloadMediaByPost(String url, String postString,  String downloadDir, String fileName, WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (downloadDir == null) {
			throw new NullPointerException("downloadDir may not be null");
		}
		
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		
		DownloadResponse response = null;
		try {
			Object respObj = PoolingHttpUtil.downloadFileByPost(url, postString, downloadDir, fileName, wechatContext, "text", "application/json");
			if (respObj == null) {
				return response;
			}
			
			if (respObj instanceof String) {
				response =  JsonMapper.nonEmptyMapper().fromJson((String) respObj, DownloadResponse.class);
				accessTokenFetcher.updateIfNecessary(response);
			} else if (respObj instanceof File) {
				response = new DownloadResponse();
				response.setErrcode(WechatErrorCode.OK);
				response.setFile((File) respObj);
			}
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url
	 * @param downloadDir
	 * @param fileName
	 * @param wechatContext
	 * @param accessTokenFetcher
	 * @return null if network error
	 * @throws NullPointerException if url, downloadDir , wecahtContext, accessTokenFetcher is null
	 */
	public static DownloadResponse downloadMediaByGet(String url, String downloadDir, String fileName, WechatContext wechatContext, AccessTokenFetcher accessTokenFetcher) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (downloadDir == null) {
			throw new NullPointerException("downloadDir may not be null");
		}
		
		if (wechatContext == null) {
			throw new NullPointerException("wechatContext may not be null");
		}
		
		if (accessTokenFetcher == null) {
			throw new NullPointerException("accessTokenFetcher may not be null");
		}
		
		DownloadResponse response = null;
		try {
			Object respObj = PoolingHttpUtil.downloadFileByGet(url, downloadDir, fileName, wechatContext, "text", "application/json");
			if (respObj == null) {
				return response;
			}
			
			if (respObj instanceof String) {
				response =  JsonMapper.nonEmptyMapper().fromJson((String) respObj, DownloadResponse.class);
				accessTokenFetcher.updateIfNecessary(response);
			} else if (respObj instanceof File) {
				response = new DownloadResponse();
				response.setErrcode(WechatErrorCode.OK);
				response.setFile((File) respObj);
			}
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
}
