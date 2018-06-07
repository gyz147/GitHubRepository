package com.njwb.joybeans.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.njwb.joybeans.pojo.BeansExchange;

/**
 * 乐豆换算比例数据操作层
 * 
 * @author soft01
 * 
 */
public interface BeansExchangeMapper {
	/**
	 * 查询乐豆换算比例
	 * 
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<BeansExchange> queryAllByCondition(Map<String, String> param) throws Exception;

	/**
	 * 查询乐豆换算比例的总数
	 * 
	 * @param provCode
	 * @return
	 * @throws SQLException
	 */
	int queryCnt(Map<String, String> param) throws Exception;

	/**
	 * 增加乐豆换算比例数据
	 * 
	 * @param beansExchange
	 * @throws SQLException
	 */
	void insertBeansExchange(BeansExchange beansExchange) throws Exception;

	/**
	 * 通过ID 查询乐豆换算比例
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	BeansExchange queryById(String id) throws Exception;

	/**
	 * 修改乐豆换算比例数据
	 * 
	 * @param beansExchange
	 * @throws SQLException
	 */
	void updateBeansExchange(BeansExchange beansExchange) throws Exception;

	/**
	 * 删除乐豆换算比例数据
	 * 
	 * @param id
	 * @throws SQLException
	 */
	void deleteBeansExchange(String id) throws Exception;

	/**
	 * 通过省份查询乐豆换算比例
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	BeansExchange queryByProvCode(String provCode) throws Exception;
}
