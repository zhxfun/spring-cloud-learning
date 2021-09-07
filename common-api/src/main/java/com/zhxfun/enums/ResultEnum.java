package com.zhxfun.enums;

/**
 * 枚举了操作码
 * 
 * @author 800P_zhangxiang
 *
 */
public enum ResultEnum {
	SUCCESS("S000A000", "交易成功"), 
	FAIL("EPF7200P", "服务异常，请稍后重试");
	private String rspCd;
	private String msg;

	private ResultEnum(String rspCd, String msg) {
		this.rspCd = rspCd;
		this.msg = msg;
	}

	public String getRspCd() {
		return rspCd;
	}

	public String getMsg() {
		return msg;
	}
}