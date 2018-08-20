package com.garfield.wechatorder.util;


/**
 * Created by konie on 16-8-23.
 */
public class CommonException extends RuntimeException {

	private final int code;

	public CommonException(int code, String message) {
		super(message);
		this.code = code;
	}

	public CommonException(IResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "CommonException code: " + code + " " + super.toString();
	}
}