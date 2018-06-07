package com.njwb.joybeans.service;

import java.util.List;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.Province;

/**
 * 省份的业务操作层
 * 
 * @author soft01
 * 
 */
public interface ProvinceService {
	/**
	 * 查询没有密保卡的省份
	 * 
	 * @return
	 * @throws JoybeansException
	 */
	List<Province> queryAllNotSecretCard() throws JoybeansException;

	/**
	 * 模糊查询没有乐豆换算比例的省份,"省份编号，省份名"
	 * 
	 * @param provName
	 * @return
	 * @throws JoybeansException
	 */
	List<String> queryAllNotBeansExchange(String provName) throws JoybeansException;
}
