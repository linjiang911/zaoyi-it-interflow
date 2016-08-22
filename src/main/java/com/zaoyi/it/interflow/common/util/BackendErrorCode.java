package com.zaoyi.it.interflow.common.util;

public enum BackendErrorCode implements ErrorCode {
	account_password_error(15,"账号或密码错误"),
	phone_verify_erroe(15,"验证码错误"),
	phone_not_exist(14,"没有该手机号码"),
	entrepreneurName_repetition(13,"公司名重复"),
	status_error(12, "状态异常"), //
	date_format_error(11, "时间格式错误"), //
	already_exist(10, "已存在/不可重复"), //
	not_exist(9, "不存在/或已删除"), //
	missing_parameter(8, "缺少参数/或为空"), //
	exception(7, null), //
	unknown_error(6, "未知错误"), //
	database_error(5, "数据库错误"), //
	account_exist(4, "帐号已存在"), //
	account_not_exist(3, "帐号不存在"), //
	account_disable(2, "帐号被禁用"), //
	account_password_not_match(1, "密码错误"); //

	private int code = 0;
	private String errorMessage = null;

	private BackendErrorCode(int code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
