package com.njwb.joybeans.service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.BeansExchange;
import com.njwb.joybeans.util.PageModel;

/**
 * 乐豆换算比例的业务操作层
 * 
 * @author soft01
 * 
 */
public interface BeansExchangeService {
	/**
	 * 查询所有乐豆换算比例
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param provCode
	 * @return
	 * @throws BeanException
	 */
	PageModel<BeansExchange> queryAllByCondition(int pageNo, int pageSize, String provName) throws JoybeansException;

	/**
	 * 增加乐豆换算比例
	 * 
	 * @throws JoybeansException
	 */
	void addBeanExchange(String provCode, String price) throws JoybeansException;

	/**
	 * 查询某个乐豆换算比例
	 * 
	 * @param id
	 * @return
	 * @throws JoybeansException
	 */
	BeansExchange queryById(String id) throws JoybeansException;

	/**
	 * 通过省份查询某个乐豆换算比例
	 * 
	 * @param id
	 * @return
	 * @throws JoybeansException
	 */
	BeansExchange queryByProvCode(String provCode) throws JoybeansException;

	/**
	 * 修改乐豆换算比例
	 * 
	 * @param provCode
	 * @param price
	 * @throws JoybeansException
	 */
	void editBeanExchange(String provCode, String price) throws JoybeansException;

	/**
	 * 删除乐豆换算比例
	 * 
	 * @param id
	 * @throws JoybeansException
	 */
	void deleteBeanExchange(String id) throws JoybeansException;

}
