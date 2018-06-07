package com.dearlg.game.dao;

import java.sql.SQLException;

import com.dearlg.game.entity.Admin;

/**
 * 管理员数据层操作
 * 
 * @author soft01
 * 
 */
public interface AdminDao {
	/**
	 * 管理员通过帐号密码登录
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 * @throws SQLException 
	 */
	public abstract Admin logByIdPwd(String id, String pwd) throws SQLException;
}
