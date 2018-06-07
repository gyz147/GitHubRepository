package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dearlg.game.entity.User;
import com.dearlg.game.util.RowMapper;

public class UserMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		User user = new User();
		user.setNumber(rs.getString("t_number"));
		user.setName(rs.getString("t_name"));
		user.setSex(rs.getString("t_sex"));
		user.setAddress(rs.getString("t_address"));
		user.setPassword(rs.getString("t_password"));
		user.setAccount(rs.getDouble("t_account"));
		user.setVirtualAccount(rs.getDouble("t_VirtualAccount"));
		user.setTime(rs.getString("t_time"));
		return user;
	}

}
