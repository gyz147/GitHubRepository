package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dearlg.game.entity.MobileUser;
import com.dearlg.game.util.RowMapper;

public class MobileUserMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		MobileUser mobilUser = new MobileUser();
		mobilUser.setNumber(rs.getString("t_number"));
		mobilUser.setName(rs.getString("t_name"));
		mobilUser.setSex(rs.getString("t_sex"));
		mobilUser.setAddress(rs.getString("t_address"));
		mobilUser.setAccount(rs.getDouble("t_account"));
		return mobilUser;
	}
}
