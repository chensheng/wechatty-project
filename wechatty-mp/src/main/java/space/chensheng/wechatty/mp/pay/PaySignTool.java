package space.chensheng.wechatty.mp.pay;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.MD5Utils;
import space.chensheng.wechatty.common.util.StringUtil;
import space.chensheng.wechatty.mp.util.MpAppContext;
import space.chensheng.wechatty.mp.util.MpWechatContext;

public class PaySignTool {
	private static final Logger logger = LoggerFactory.getLogger(PaySignTool.class);
	
	private static final String EMPTY_STRING = "";
	
	public static String sign(Map<String, Object> params, MpAppContext appContext) {
		MpWechatContext wechatContext = (MpWechatContext) appContext.getWechatContext();
		String sortedParams = sortParams(params);
		String unsignParams = String.format("%s&key=%s", sortedParams, wechatContext.getPayKey());		
		return MD5Utils.md5With32(unsignParams).toUpperCase();
	}
	
	public static String sign(Object params, MpAppContext appContext) {
		Map<String, Object> mapParams = objectToMap(params);
		return sign(mapParams, appContext);
	}
	
	private static Map<String, Object> objectToMap(Object params) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (params == null) {
			return map;
		}
		
		Field[] fields = params.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				
				Object value = field.get(params);
				if (value == null) {
					continue;
				}
				
				String name = field.getName();
				XStreamAlias alias = field.getAnnotation(XStreamAlias.class);
				if (alias != null) {
					name = alias.value();
				}
				
				map.put(name, value);
			} catch (IllegalArgumentException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			} catch (IllegalAccessException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
		
		return map;
	}
	
	private static String sortParams(Map<String, Object> params) {
		if (params == null || params.size() == 0) {
			return EMPTY_STRING;
		}
		
		List<String> names = new ArrayList<String>();
		names.addAll(params.keySet());
		names.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		StringBuilder sortedParams = new StringBuilder();
		for (String name : names) {
			Object value = params.get(name);
			if (value == null || StringUtil.isEmpty(value.toString())) {
				continue;
			}
			sortedParams.append(name);
			sortedParams.append("=");
			sortedParams.append(value);
			sortedParams.append("&");
		}
		sortedParams.deleteCharAt(sortedParams.length() - 1);
		
		return sortedParams.toString();
	}
	
}
