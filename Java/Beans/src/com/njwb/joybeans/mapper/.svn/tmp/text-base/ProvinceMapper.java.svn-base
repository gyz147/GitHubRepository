package com.njwb.joybeans.mapper;

import java.util.List;

import com.njwb.joybeans.pojo.Province;

/**
 * 省份数据操作层
 * 
 * @author soft01
 * 
 */
public interface ProvinceMapper {
	/**
	 * 查询可生成密保卡的省份
	 * 
	 * @param provName
	 * @return
	 * @throws Exception
	 */
	List<Province> queryAllNotSecretCard() throws Exception;

	/**
	 * 模糊查询没有乐豆兑换比例的省份
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Province> queryAllNotBeansExchange(String provName) throws Exception;
}
