package space.chensheng.wechatty.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String md5With16(String input) {
		return code(input, 16);
	}

	public static String md5With32(String input) {
		return code(input, 32);
	}
	
	public static String md5With16(byte[] input) {
		return code(input, 16);
	}

	public static String md5With32(byte[] input) {
		return code(input, 32);
	}

	public static String md3(String b) {
		try {
			MessageDigest md = MessageDigest.getInstance(System.getProperty("MD5.algorithm", "MD5"));
			byte[] a = md.digest(b.getBytes());
			a = md.digest(a);
			a = md.digest(a);
			return bytesToHex(a);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String code(byte[] input, int bit) {
		if (input == null) {
			return null;
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance(System.getProperty("MD5.algorithm", "MD5"));
			if (bit == 16) {
				return bytesToHex(md.digest(input)).substring(8, 24);
			}
			
			return bytesToHex(md.digest(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String code(String input, int bit) {
		if (input == null) {
			return null;
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance(System.getProperty("MD5.algorithm", "MD5"));
			if (bit == 16) {
				return bytesToHex(md.digest(input.getBytes("utf-8"))).substring(8, 24);
			}
			
			return bytesToHex(md.digest(input.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();   
	    int digital;  
	    for (int i = 0; i < bytes.length; i++) {  
	        digital = bytes[i];
	        if (digital < 0) {  
	        digital += 256;  
	        }  
	        if (digital < 16) {  
	        md5str.append("0");  
	        }  
	        md5str.append(Integer.toHexString(digital));  
	    }  
	    
	    return md5str.toString().toUpperCase();  
	}

}
