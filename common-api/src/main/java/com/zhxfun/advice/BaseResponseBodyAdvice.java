package com.zhxfun.advice;

import com.zhxfun.pojo.Result;
import com.zhxfun.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;



/**
 * 基础响应处理<br>
 * 响应数据加密br>
 * 响应数据记录br>
 * @author 800P_zhangxiang
 *
 */
@Order(0)
@ControllerAdvice
public class BaseResponseBodyAdvice implements ResponseBodyAdvice<Object> {
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseResponseBodyAdvice.class);

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		LOGGER.info("前端响应报文 ==> \n{}", JsonUtil.encode(body));
		if (body instanceof Result) {
			return body;
		}
		return Result.success(body);
	}
}