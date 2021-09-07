package com.zhxfun.exception;


import com.zhxfun.enums.ResultEnum;

/**
 * 自定义业务异常
 * 
 * @author 800P_zhangxiang
 *
 */
public class BizException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ResultEnum resultEnum;

	public BizException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.resultEnum = resultEnum;
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResultEnum getErrorCode() {
		return resultEnum;
	}
}
