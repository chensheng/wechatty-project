package space.chensheng.wechatty.common.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.util.ExceptionUtil;

public class PoolingHttpUtil {
	private static final Logger logger = LoggerFactory.getLogger(PoolingHttpUtil.class);
	
	public static String get(String url, WechatContext wechatContext) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			response = PoolingHttpClient.getInstance(wechatContext).execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity());
			}
			if (response != null) {
				EntityUtils.consume(response.getEntity());
			}
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
			httpGet.releaseConnection();
		}
		return null;
	}
	
	public static String postString(String url, String postString, WechatContext wechatContext) throws ClientProtocolException, IOException {
		return postString(url, postString, null, wechatContext);
	}
	
	public static String postString(String url, String postString, RequestConfig config, WechatContext wechatContext) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		if(config != null) {
			httpPost.setConfig(config);
		}
		if(postString == null) {
			postString = "";
		}
		CloseableHttpResponse response = null;
		
		try {
			httpPost.setEntity(new StringEntity(postString, Consts.UTF_8));
			response = PoolingHttpClient.getInstance(wechatContext).execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity());
			}
			if (response != null) {
				EntityUtils.consume(response.getEntity());
			}
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
			httpPost.releaseConnection();
		}
		
		return null;
	}
	
	public static String postMultipart(String url, Map<String, Object> params, WechatContext wechatContext) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create();
	
		if (params != null) {
			Iterator<Entry<String, Object>> it = params.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Object> entry = it.next();
				Object valueObj = entry.getValue();
				if (valueObj instanceof File) {
					File file = (File) valueObj;
					FileBody fileBody = new FileBody(file);
					meBuilder.addPart(entry.getKey(), fileBody);
				} else {
					String valueStr = String.valueOf(valueObj);
					meBuilder.addTextBody(entry.getKey(), valueStr, ContentType.create("text/plain", Consts.UTF_8));
				}
			}
		}
		
		CloseableHttpResponse response = null;
		try {
			httpPost.setEntity(meBuilder.build());
			response = PoolingHttpClient.getInstance(wechatContext).execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity());
			}
			if (response != null) {
				EntityUtils.consume(response.getEntity());
			}
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}				
			}
			httpPost.releaseConnection();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param url
	 * @param postString
	 * @param downloadDir
	 * @param fileName
	 * @param wechatContext
	 * @param ignoreContentTypes
	 * @return string if response content type is in {@code ignoreContentTypes}, file if download success, otherwise null. 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static Object downloadFileByPost(String url, String postString,  String downloadDir, String fileName, WechatContext wechatContext, String...ignoreContentTypes) throws ClientProtocolException, IOException {
		Object file = null;
		CloseableHttpResponse response = null;
		HttpPost httpPost = new HttpPost(url);
		if(postString == null) {
			postString = "";
		}
		
		try {
			httpPost.setEntity(new StringEntity(postString, Consts.UTF_8));
			response = PoolingHttpClient.getInstance(wechatContext).execute(httpPost);
			file = doDownload(response, downloadDir, fileName, ignoreContentTypes);
			if (response != null) {
				EntityUtils.consume(response.getEntity());
			}
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
			httpPost.releaseConnection();
		}
		
		return file;
	}
	
	/**
	 * 
	 * @param url
	 * @param downloadDir
	 * @param fileName
	 * @param wechatContext
	 * @param ignoreContentTypes 
	 * @return string if response content type is in {@code ignoreContentTypes}, file if download success, otherwise null. 
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static Object downloadFileByGet(String url, String downloadDir, String fileName, WechatContext wechatContext, String...ignoreContentTypes) throws IllegalStateException, IOException {
		Object file = null;
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response  = null;
		
		try {
			response = PoolingHttpClient.getInstance(wechatContext).execute(httpGet);
			file = doDownload(response, downloadDir, fileName, ignoreContentTypes);
			if (response != null) {
				EntityUtils.consume(response.getEntity());
			}
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
			httpGet.releaseConnection();
		}
		
		return file;
	}
	
	private static Object doDownload(CloseableHttpResponse response, String downloadDir, String fileName, String... ignoreContentTypes) {
		if (response == null || response.getEntity() == null) {
			return null;
		}
		
		if (!validateContent(response, ignoreContentTypes)) {
			try {
				return EntityUtils.toString(response.getEntity());
			} catch (ParseException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			} catch (IOException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
		
		File dir = new File(downloadDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		fileName = generateFileName(fileName, response);
		File file = new File(downloadDir + File.separator + fileName);
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			is = response.getEntity().getContent();
			fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer, 0, 1024)) != -1) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
			
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					logger.error(ExceptionUtil.getExceptionDetails(e));
				}
			}
		}
		
		return file;
	}
	
	private static boolean validateContent(CloseableHttpResponse response, String[] ignoreContentTypes) {		
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			return false;
		}
		
		long contentLen = response.getEntity().getContentLength();
		if (contentLen == 0) {
			return false;
		}
		
		Header contentTypeHeader = response.getEntity().getContentType();
		if (ignoreContentTypes != null && contentTypeHeader != null && contentTypeHeader.getValue() != null) {
			for (String ignoreType : ignoreContentTypes) {
				if (contentTypeHeader.getValue().contains(ignoreType)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static String generateFileName(String fileName, CloseableHttpResponse response) {
		if (fileName == null) {
			fileName = resolveFileName(response);
		}
		
		if (fileName == null) {
			Random random = new Random();
			fileName = String.format("download_%s_%s", System.currentTimeMillis(), random.nextInt(1000));
		}
		
		return fileName;
	}
	
	private static String resolveFileName(CloseableHttpResponse response) {
		Header[] headers = response.getHeaders("Content-disposition");
		if (headers != null && headers.length > 0) {
			for (Header header : headers) {
				HeaderElement[] eles = header.getElements();
				for(HeaderElement ele : eles) {
					NameValuePair nvp = ele.getParameterByName("filename");
					if (nvp != null) {
						return nvp.getValue();
					}
				}
			}
		}
		return null;
	}
}
