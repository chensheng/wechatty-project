package space.chensheng.wechatty.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class JsonMapper {
	private static final JsonMapper NON_EMPTY_INSTANCE = new JsonMapper(Include.NON_EMPTY);
	
	private static final JsonMapper NON_DEFAULT_INSTANCE = new JsonMapper(Include.NON_DEFAULT);

	public static JsonMapper nonEmptyMapper() {
		return NON_EMPTY_INSTANCE;
	}

	public static JsonMapper nonDefaultMapper() {
		return NON_DEFAULT_INSTANCE;
	}
	
	
	private ObjectMapper mapper;

	private JsonMapper() {
		this(null);
	}

	private JsonMapper(Include include) {
		mapper = new ObjectMapper();
		
		if (include != null) {
			mapper.setSerializationInclusion(include);
		}
		this.enableEnumUseToString();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
	}
	
	public String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			return null;
		}
	}

	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtil.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (Throwable e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtil.isEmpty(jsonString)) {
			return null;
		}

		try {
			return (T) (mapper.readValue(jsonString, javaType));
		} catch (IOException e) {
			return null;
		}
	}

	public JavaType contructCollectionType(Class<? extends Collection<?>> collectionClass, Class<?> elementClass) {
		return mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
	}

	public JavaType contructMapType(Class<? extends Map<?,?>> mapClass, Class<?> keyClass, Class<?> valueClass) {
		return mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
	}

	public void update(String jsonString, Object object) {
		try {
			mapper.readerForUpdating(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
		} catch (IOException e) {
		}
	}

	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}

	private void enableEnumUseToString() {
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	}
}
