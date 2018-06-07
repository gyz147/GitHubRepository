package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Config;

/**
 * 配置信息的数据操作层
 * 
 * @author soft01
 * 
 */
public interface ConfigDao {
	/**
	 * 通过配置ID查配置字段
	 * 
	 * @param type
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<Config> queryValueById(String type) throws SQLException;
}
