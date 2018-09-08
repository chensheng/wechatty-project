package space.chensheng.wechatty.common.http;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.JsonMapper;
import space.chensheng.wechatty.common.util.XmlUtil;

public class WechatRequester {
	private static final Logger logger = LoggerFactory.getLogger(WechatRequester.class);
	
	private AppContext appContext;
	
	public WechatRequester(AppContext appContext) {
		if (appContext == null) {
			throw new NullPointerException("appContext must not be null");
		}
		
		this.appContext = appContext;
	}
	
	/**
	 * 
	 * @param url request URL
	 * @param retClzz class of response object
	 * @param <T>
	 * @return null if network error
	 * @throws NullPointerException if any argument is null
	 */
	public <T> T get(String url, Class<T> retClzz) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = appContext.getPoolingHttpUtil().get(url);
			if (responseStr != null) {
				responseStr = new String(responseStr.getBytes("ISO-8859-1"), "UTF-8");
			}
			response = JsonMapper.nonEmptyMapper().fromJson(responseStr, retClzz);
			appContext.getAccessTokenFetcher().updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url request URL
	 * @param postString request body
	 * @param retClzz class of response object
	 * @return null if network error
	 * @throws NullPointerException if any argument except {@code postString} is null
	 */
	public <T> T postString(String url, String postString, Class<T> retClzz) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = appContext.getPoolingHttpUtil().postString(url, postString);
			if (responseStr != null) {
				responseStr = new String(responseStr.getBytes("ISO-8859-1"), "UTF-8");
			}
			response = JsonMapper.nonEmptyMapper().fromJson(responseStr, retClzz);
			appContext.getAccessTokenFetcher().updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url request URL
	 * @param postData request parameters
	 * @param retClzz class of response object
	 * @return null if network error
	 * @throws NullPointerException if any argument except {@code postData} is null
	 */
	public <T> T postMultipart(String url, Map<String, Object> postData, Class<T> retClzz) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = appContext.getPoolingHttpUtil().postMultipart(url, postData);
			if (responseStr != null) {
				responseStr = new String(responseStr.getBytes("ISO-8859-1"), "UTF-8");
			}
			response = JsonMapper.nonEmptyMapper().fromJson(responseStr, retClzz);
			appContext.getAccessTokenFetcher().updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
	
	/**
	 * 
	 * @param url media URL
	 * @param postString request body
	 * @param downloadDir directory to save file
	 * @param fileName download file name
	 * @return null if network error
	 * @throws NullPointerException if url, downloadDir is null
	 */
	public DownloadResponse downloadMediaByPost(String url, String postString,  String downloadDir, String fileName) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (downloadDir == null) {
			throw new NullPointerException("downloadDir may not be null");
		}
		
		DownloadResponse response = null;
		try {
			Object respObj = appContext.getPoolingHttpUtil().downloadFileByPost(url, postString, downloadDir, fileName, "text", "application/json");
			if (respObj == null) {
				return response;
			}
			
			if (respObj instanceof String) {
				response =  JsonMapper.nonEmptyMapper().fromJson((String) respObj, DownloadResponse.class);
				appContext.getAccessTokenFetcher().updateIfNecessary(response);
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
	 * @param url media URL
	 * @param downloadDir directory to save download media
	 * @param fileName download file name
	 * @return null if network error
	 * @throws NullPointerException if url, downloadDir is null
	 */
	public DownloadResponse downloadMediaByGet(String url, String downloadDir, String fileName) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (downloadDir == null) {
			throw new NullPointerException("downloadDir may not be null");
		}
		
		DownloadResponse response = null;
		try {
			Object respObj = appContext.getPoolingHttpUtil().downloadFileByGet(url, downloadDir, fileName, "text", "application/json");
			if (respObj == null) {
				return response;
			}
			
			if (respObj instanceof String) {
				response =  JsonMapper.nonEmptyMapper().fromJson((String) respObj, DownloadResponse.class);
				appContext.getAccessTokenFetcher().updateIfNecessary(response);
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
	 * @param url request URL
	 * @param postString request body
	 * @param retClzz class of response body
	 * @return null if network error
	 * @throws NullPointerException if any argument except {@code postString} is null
	 */
	public <T> T postStringAndRespXml(String url, String postString, Class<T> retClzz) {
		if (url == null) {
			throw new NullPointerException("url may not be null");
		}
		
		if (retClzz == null) {
			throw new NullPointerException("retClzz may not be null");
		}
		
		T response = null;
		
		try {
			String responseStr = appContext.getPoolingHttpUtil().postString(url, postString);
			response = XmlUtil.fromXMLIgnoreUnknownElements(responseStr, retClzz);
			appContext.getAccessTokenFetcher().updateIfNecessary(response);
		} catch (ClientProtocolException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return response;
	}
}
