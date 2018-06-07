package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Config;
import com.njwb.oa.util.RowMapper;

public class ConfigMapper implements RowMapper {
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Config config = new Config();
		config.setTyep(rs.getString("t_type"));
		config.setId(rs.getString("t_keyID"));
		config.setValue(rs.getString("t_value"));
		return config;
	}
}
