package com.zhxfun.advice;

import java.io.IOException;
import java.lang.reflect.Type;

import com.zhxfun.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;



/**
 * 基础请求处理<br>
 * 请求数据解密<br>
 *请求日志记录<br> 
 * 
 * @author 800P_zhangxiang
 *
 */
@Order(0)
@ControllerAdvice
public class BaseRequestBodyAdvice extends RequestBodyAdviceAdapter {
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseRequestBodyAdvice.class);

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return methodParameter.hasParameterAnnotation(RequestBody.class);
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		return inputMessage;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		LOGGER.info("前端请求报文 ==> \n{}", JsonUtil.encode(body));
		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}
}
