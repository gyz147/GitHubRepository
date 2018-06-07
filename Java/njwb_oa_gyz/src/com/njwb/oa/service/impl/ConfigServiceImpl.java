package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.ConfigDao;
import com.njwb.oa.entity.Config;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.ConfigService;

public class ConfigServiceImpl implements ConfigService {
	private ConfigDao configDao;

	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

	@Override
	public List<Config> queryValueById(String type) throws OAException {
		List<Config> configList = null;
		try {
			configList = configDao.queryValueById(type);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return configList;
	}
}
