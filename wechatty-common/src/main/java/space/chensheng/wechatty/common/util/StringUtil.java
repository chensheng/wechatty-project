package space.chensheng.wechatty.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().equals("")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static int parseToInt(String str, int defaultVal) {
		if (isNotEmpty(str)) {
			try {
				return Integer.valueOf(str);
			} catch (NumberFormatException e) {
				return defaultVal;
			}
		}
		return defaultVal;
	}
	
	public static Integer parseToInteger(String str, Integer defaultVal) {
		if (isNotEmpty(str)) {
			try {
				return Integer.valueOf(str);
			} catch (NumberFormatException e) {
				return defaultVal;
			}
		}
		return defaultVal;
	}
	
	public static long parseToLong(String str, long defaultVal) {
		if(isNotEmpty(str)) {
			try {
				return Long.valueOf(str);
			} catch (NumberFormatException e) {
				return defaultVal;
			}
		}
		return defaultVal;
	}
	
	public static double parseToDouble(String str, double defaultVal) {
		if(isNotEmpty(str)) {
			try {
				return Double.valueOf(str);
			} catch (NumberFormatException e) {
				return defaultVal;
			}
		}
		return defaultVal;
	}
	
	public static int retrieveInt(String str, int defaultVal) {
		if (isNotEmpty(str)) {
			str = str.replaceAll("[^0-9]", "");
			return parseToInt(str, defaultVal);
		}
		return defaultVal;
	}
	
	public static String getRandomStr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = ThreadLocalRandom.current().nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public static String readInputStream(InputStream is) {
		StringBuilder result = new StringBuilder();
		String line = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
		
		return result.toString();
	}
}
