package com.njwb.joybeans.service;

import java.sql.SQLException;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.SysUser;

/**
 * 管理员用户的业务操作层
 * 
 * @author soft01
 * 
 */
public interface SysUserService {
	/**
	 * 通过返回管理员的“手机号,验证码”
	 * 
	 * @param userAccount
	 * @return
	 * @throws SQLException
	 */
	String getMessage(String userAccount) throws JoybeansException;

	/**
	 * 管理员登录乐豆管理系统
	 * 
	 * @param userAccount
	 * @param userPwd
	 * @return
	 * @throws BeanException
	 */
	SysUser login(String userAccount, String userPwd) throws JoybeansException;
}
