package space.chensheng.wechatty.common.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.MD5Utils;
import space.chensheng.wechatty.common.util.StringUtil;

public class Aes256EcbCrypt {
	private static final Logger logger = LoggerFactory.getLogger(Aes256EcbCrypt.class);
	
	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	public static String decrypt(String key, String encryptedData) {
		if (StringUtil.isEmpty(key) || StringUtil.isEmpty(encryptedData)) {
			return null;
		}
		
		byte[] aesKey = MD5Utils.md5With32(key).toLowerCase().getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			byte[] encrypted = Base64.decodeBase64(encryptedData);
		    return new String(cipher.doFinal(encrypted));
		} catch (NoSuchAlgorithmException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (NoSuchPaddingException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (InvalidKeyException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (IllegalBlockSizeException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (BadPaddingException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} catch (NoSuchProviderException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		
		return null;
	}
}
