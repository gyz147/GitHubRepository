package com.njwb.joybeans.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.njwb.joybeans.pojo.SysUser;

/**
 * 管理员数据操作层
 * 
 * @author soft01
 * 
 */
public interface SysUserMapper {
	/**
	 * 通过账号查询用户的手机号
	 * 
	 * @param userAccount
	 * @return
	 * @throws SQLException
	 */
	String queryPhoneByAccount(String userAccount) throws Exception;

	/**
	 * 登录乐豆管理系统
	 * @param userAccount
	 * @return
	 * @throws SQLException
	 */
	SysUser loginByAccountPwd(Map<String, String> param) throws Exception;
}
