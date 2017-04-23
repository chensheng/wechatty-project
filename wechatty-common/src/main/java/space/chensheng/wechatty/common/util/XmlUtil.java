package space.chensheng.wechatty.common.util;

import java.io.InputStream;
import java.io.Writer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

/**
 * Use XStream to convert between XML and POJO.
 * @author sheng.chen
 */
public class XmlUtil {
	private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);
	
	/**
	 * Convert from POJO to XML string
	 * @param pojo
	 * @return XML string stands for the POJO
	 */
	public static String toXML(Object pojo) {
		if (pojo == null) {
			return "";
		}
		
		XStream xstream = createXStream(pojo.getClass());
		try {
			return xstream.toXML(pojo);
		} catch (XStreamException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
			return "";
		}
	}
	
	
	/**
	 * Convert from XML string to POJO
	 * @param xmlStr
	 * @param clzz the class of POJO
	 * @return POJO
	 */
	public static <T> T fromXML(String xmlStr, Class<T> clzz) {
		XStream xstream = createXStream(clzz);
		
		try {
			@SuppressWarnings("unchecked")
			T pojo = (T) xstream.fromXML(xmlStr);
			return pojo;
		} catch (XStreamException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
			return null;
		}
	}
	
	public static <T> T fromXMLIgnoreUnknownElements(String xmlStr, Class<T> clzz) {
		XStream xstream = createXStream(clzz);
		xstream.ignoreUnknownElements();
		
		try {
			@SuppressWarnings("unchecked")
			T pojo = (T) xstream.fromXML(xmlStr);
			return pojo;
		} catch (XStreamException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
			return null;
		}
	}
	
	public static <T> T fromXML(InputStream is, Class<T> clzz) {
		XStream xstream = createXStream(clzz);
		
		try {
			@SuppressWarnings("unchecked")
			T pojo = (T) xstream.fromXML(is);
			return pojo;
		} catch (XStreamException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
			return null;
		}
	}
	
	public static <T> T fromXMLIgnoreUnknownElements(InputStream is, Class<T> clzz) {
		XStream xstream = createXStream(clzz);
		xstream.ignoreUnknownElements();
		
		try {
			@SuppressWarnings("unchecked")
			T pojo = (T) xstream.fromXML(is);
			return pojo;
		} catch (XStreamException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
			return null;
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface XStreamCDATA {
	}

	private static XStream createXStream(final Class<?> targetClass) {
		final String typeAlias = findTypeAlias(targetClass);
		Xpp3Driver xppDriver = new Xpp3Driver() {
			@Override
			public HierarchicalStreamWriter createWriter(Writer out) {
				HierarchicalStreamWriter writer = new PrettyPrintWriter(out) {
					boolean cdata = false;  
					@Override
					public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
						if (targetClass.equals(clazz)) {
							if (typeAlias != null) {
								name = typeAlias;
							}
						}
						super.startNode(name, clazz);
						if(!name.equals("xml")){
							cdata = needCDATA(targetClass, name);
						}
					}
					
					@Override
					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write(toCDATA(text));
                        } else {
                        	writer.write(text);
                        }  
					}
					
					private String toCDATA(String text) {
						String cdataStr = "<![CDATA[" + text + "]]>";
						return cdataStr;
					}
				};
				return writer;
			}
		};
		
		XStream xstream = new XStream(xppDriver);
		xstream.processAnnotations(targetClass);
		if (typeAlias != null) {
			xstream.alias(typeAlias, targetClass);
		}
		return xstream;
	}
	
	private static String findTypeAlias(Class<?> clazz) {
		if (clazz == null) {
			return null;
		}
		while (clazz != null && !clazz.equals(Object.class) && clazz.getAnnotation(XStreamAlias.class) == null) {
			clazz = clazz.getSuperclass();
		}
		
		if (clazz != null && clazz.getAnnotation(XStreamAlias.class) != null) {
			return clazz.getAnnotation(XStreamAlias.class).value();
		}
		
		return null;
	}
	
	private static boolean needCDATA(Class<?> targetClass, String fieldAlias){  
		if (targetClass == null) {
			return false;
		}
		boolean cdata = false;
        cdata = existsCDATA(targetClass, fieldAlias);  
        if(cdata) {
        	return cdata;  
        }
        
        Class<?> superClass = targetClass.getSuperclass();  
        while(!superClass.equals(Object.class)){  
            cdata = existsCDATA(superClass, fieldAlias);  
            if(cdata) {
            	return cdata;  
            }
            superClass = superClass.getClass().getSuperclass();  
        }  
        return false;  
    }  
	
	private static boolean existsCDATA(Class<?> clzz, String fieldAlias) {
		Field[] fields = clzz.getDeclaredFields();  
		for (Field field : fields) {  
			if (field.getAnnotation(XStreamCDATA.class) != null ) {  
				XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);  
				if (null != xStreamAlias) {
					if(fieldAlias.equals(xStreamAlias.value())){
						 return true;
					}
                } else if(fieldAlias.equals(field.getName())) {
                	return true;
                }
            }  
        }
		return false;  
	}
}
