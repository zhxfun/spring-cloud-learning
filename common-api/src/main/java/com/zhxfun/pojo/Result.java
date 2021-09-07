package com.zhxfun.pojo;

import java.io.Serializable;

import com.zhxfun.enums.ResultEnum;

/**
 * 通用返回对象
 * @author 800P_zhangxiang
 *
 * @param <T>
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 状态码
	 */
	private String rspCd;
	/**
	 * 提示信息
	 */
	private String msg;
	/**
	 * 数据封装
	 */
	private T data;

	protected Result() {
	}

	protected Result(String rspCd, String msg) {
		this.rspCd = rspCd;
		this.msg = msg;
	}

	protected Result(String rspCd, String msg, T data) {
		this.rspCd = rspCd;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 成功返回结果
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data) {
		return new Result<T>(ResultEnum.SUCCESS.getRspCd(), ResultEnum.SUCCESS.getMsg(), data);
	}

	/**
	 * 成功返回结果
	 * @param data
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> success(T data, String msg) {
		return new Result<T>(ResultEnum.SUCCESS.getRspCd(), msg, data);
	}

	/**
	 *  失败返回结果
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> failed(String msg) {
		return new Result<T>(ResultEnum.FAIL.getRspCd(), msg);
	}
	
	/**
	 *  失败返回结果
	 * @param resultEnum
	 * @return
	 */
	public static <T> Result<T> fail(ResultEnum resultEnum) {
		return new Result<T>(resultEnum.getRspCd(), resultEnum.getMsg());
	}

	/**
	 *  失败返回结果
	 * @param resultEnum
	 * @param data
	 * @return
	 */
	public static <T> Result<T> fail(ResultEnum resultEnum, T data) {
		return new Result<T>(resultEnum.getRspCd(), resultEnum.getMsg(), data);
	}

	public String getRspCd() {
		return rspCd;
	}

	public void setRspCd(String rspCd) {
		this.rspCd = rspCd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
