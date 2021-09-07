package com.zhxfun.exception;


import com.zhxfun.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * 
 * @author 800P_zhangxiang
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/**
	 * 业务异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = BizException.class)
	public Result<Object> handle(BizException e) {
		LOGGER.error("发生业务异常！原因是：{}",e.getMessage(),e);
		if (e.getErrorCode() != null) {
			return Result.fail(e.getErrorCode());
		}
		return Result.failed(e.getMessage());
	}
	
	/**
	 * 全局异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public Result<Object> handle(Exception e) {
		LOGGER.error("未知异常！原因是:",e);
		return Result.failed(e.getMessage());
	}
}
