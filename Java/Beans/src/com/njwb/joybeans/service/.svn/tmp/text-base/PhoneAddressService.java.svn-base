package com.njwb.joybeans.service;

import com.njwb.joybeans.exception.JoybeansException;

/**
 * 手机号码归属地的业务操作层
 * 
 * @author soft01
 * 
 */
public interface PhoneAddressService {
	/**
	 * 查询手机号是否在手机号归属地表中，true表示存在
	 * 
	 * @param phone
	 * @return
	 * @throws JoybeansException
	 */
	boolean phoneIsExist(String phone) throws JoybeansException;

	/**
	 * 查询手机号的归属地
	 * 
	 * @param phone
	 * @return
	 * @throws JoybeansException
	 */
	String queryAddress(String phone) throws JoybeansException;
}
