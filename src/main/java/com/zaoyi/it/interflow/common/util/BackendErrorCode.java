package com.zaoyi.it.interflow.common.util;

public enum BackendErrorCode implements ErrorCode {
	account_password_error(15,"�˺Ż��������"),
	phone_verify_erroe(15,"��֤�����"),
	phone_not_exist(14,"û�и��ֻ�����"),
	entrepreneurName_repetition(13,"��˾���ظ�"),
	status_error(12, "״̬�쳣"), //
	date_format_error(11, "ʱ���ʽ����"), //
	already_exist(10, "�Ѵ���/�����ظ�"), //
	not_exist(9, "������/����ɾ��"), //
	missing_parameter(8, "ȱ�ٲ���/��Ϊ��"), //
	exception(7, null), //
	unknown_error(6, "δ֪����"), //
	database_error(5, "���ݿ����"), //
	account_exist(4, "�ʺ��Ѵ���"), //
	account_not_exist(3, "�ʺŲ�����"), //
	account_disable(2, "�ʺű�����"), //
	account_password_not_match(1, "�������"); //

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
