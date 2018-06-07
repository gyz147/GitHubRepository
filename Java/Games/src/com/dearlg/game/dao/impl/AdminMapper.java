package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dearlg.game.entity.Admin;
import com.dearlg.game.util.RowMapper;

public class AdminMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getString("t_id"));
		admin.setPassword(rs.getString("t_password"));
		return admin;
	}

}
