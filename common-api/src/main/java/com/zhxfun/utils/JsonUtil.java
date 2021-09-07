package com.zhxfun.utils;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json序列化工具
 * 
 * @author 800P_zhangxiang
 *
 */
public class JsonUtil {
	
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

	private final static ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS, true);
		objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static ObjectMapper getInstance() {
		return objectMapper;
	};

	/**
	 * 将对象序列化成json string
	 * 
	 * @param obj
	 * @return
	 */
	public static String encode(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error("将对象序列化成json string异常", e);
		}
		return null;
	}

	/**
	 * 将json string 反序列化成对象
	 * 
	 * @param json
	 * @param valueType
	 * @return
	 */
	public static <T> T decode(String json, Class<T> valueType) {
		try {
			return objectMapper.readValue(json, valueType);
		} catch (JsonProcessingException e) {
			LOGGER.error("将json string 反序列化成对象异常", e);
		}
		return null;
	}

	/**
	 * 将json array 反序列化成对象
	 * 
	 * @param json
	 * @param typeReference
	 * @return
	 */
	public static <T> T decode(String json, TypeReference<T> typeReference) {
		try {
			return (T) objectMapper.readValue(json, typeReference);
		} catch (JsonProcessingException e) {
			LOGGER.error("将json array 反序列化成对象异常", e);
		}
		return null;
	}
}
