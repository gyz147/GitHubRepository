package com.njwb.oa.service;

import java.util.List;

import com.njwb.oa.entity.Config;
import com.njwb.oa.exception.OAException;

/**
 * 配置信息的业务操作层
 * 
 * @author soft01
 * 
 */
public interface ConfigService {
	/**
	 * 通过配置ID查配置值
	 * 
	 * @param type
	 * @param id
	 * @return
	 * @throws OAException
	 */
	List<Config> queryValueById(String type) throws OAException;
}
