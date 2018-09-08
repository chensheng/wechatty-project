package space.chensheng.wechatty.common.util;

import java.util.concurrent.ThreadLocalRandom;

public class StringUtil {
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
}
