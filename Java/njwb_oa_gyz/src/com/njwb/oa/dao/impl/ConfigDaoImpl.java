package com.njwb.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.ConfigDao;
import com.njwb.oa.entity.Config;
import com.njwb.oa.util.JdbcTemplate;

public class ConfigDaoImpl implements ConfigDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Config> queryValueById(String type) throws SQLException {
		String sql = "select t_type,t_keyID,t_value from t_config where t_type=?";
		List<Config> configList = JdbcTemplate.executeQuery(sql, new ConfigMapper(), type);
		return configList;
	}
}
