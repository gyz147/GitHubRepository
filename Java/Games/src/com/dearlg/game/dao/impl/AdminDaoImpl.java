package com.dearlg.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.dao.AdminDao;
import com.dearlg.game.entity.Admin;
import com.dearlg.game.util.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {

	@SuppressWarnings("unchecked")
	@Override
	public Admin logByIdPwd(String id, String pwd) throws SQLException {
		Admin admin = null;
		String sql = "select t_id,t_password from t_admin where t_id=? and t_password=?";
		List<Admin> Adminlist = JdbcTemplate.executeQuery(sql, new AdminMapper(), id, pwd);
		if (Adminlist.size() > 0) {
			admin = Adminlist.get(0);
		}
		return admin;
	}

}
