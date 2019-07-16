package space.chensheng.wechatty.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHA1Utils {
	private static final Logger logger = LoggerFactory.getLogger(SHA1Utils.class);
	
	private static final String EMPTY_STRING = "";
	
	public static String encode(String rawString) {
		if (StringUtil.isEmpty(rawString)) {
			return EMPTY_STRING;
		}
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(rawString.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
			return EMPTY_STRING;
		}
	}
}
