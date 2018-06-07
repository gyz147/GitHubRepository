package com.dearlg.game.exception;

/**
 * 错误码
 * 
 * @author Administrator
 * 
 */
public interface ErrorCode {
	public static final String NUMBER_IS_EMPTY_ERROR = "10001";
	public static final String NUMBER_IS_EMPTY_ERROR_MSG = "手机号不能为空";

	public static final String NUMBER_IS_INVALID_ERROR = "10002";
	public static final String NUMBER_IS_INVALID_ERROR_MSG = "手机号不匹配";

	public static final String NUMBER_IS_EXIST_ERROR = "10003";
	public static final String NUMBER_IS_EXIST_ERROR_MSG = "该手机号已注册";

	public static final String PASSWORD_IS_EMPTY_ERROR = "10004";
	public static final String PASSWORD_IS_EMPTY_ERROR_MSG = "密码不能为空";

	public static final String PASSWORD_IS_INVALID_ERROR = "10005";
	public static final String PASSWORD_IS_INVALID_ERROR_MSG = "密码必须是6-10位字母或数字";

	public static final String CONFIRMPWD_IS_ERROR = "10006";
	public static final String CONFIRMPWD_IS_ERROR_MSG = "两次密码不一致";

	public static final String LOG_IS_ERROR = "10007";
	public static final String LOG_IS_ERROR_MSG = "帐号或密码错误";

	public static final String GAMETYPE_IS_INVALID_ERROR = "20001";
	public static final String GAMETYPE_IS_INVALID_ERROR_MSG = "游戏类型不符合";

}
