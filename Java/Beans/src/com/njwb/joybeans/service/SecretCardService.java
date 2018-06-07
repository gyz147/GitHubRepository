package com.njwb.joybeans.service;

import java.util.Date;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.SecretCard;
import com.njwb.joybeans.util.PageModel;

/**
 * 密保卡的业务操作层
 * 
 * @author soft01
 * 
 */
public interface SecretCardService {

	/**
	 * 分页查询所有密保卡
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param provName
	 * @return
	 * @throws Exception
	 */
	PageModel<SecretCard> queryAllByCondition(int pageNo, int pageSize, String cardNo, String provName, Date endTime) throws JoybeansException;

	/**
	 * 批量生成密保卡
	 */
	void insertSecretCards(int cardNumbers, String provStr, int beansNumber, String startTime, String endTime) throws JoybeansException;

	/**
	 * 通过账号密码查询密保卡
	 * 
	 * @param cardNo
	 * @param cardPwd
	 * @return
	 * @throws JoybeansException
	 */
	SecretCard querySecretPrice(String cardNo, String cardPwd) throws JoybeansException;
}
