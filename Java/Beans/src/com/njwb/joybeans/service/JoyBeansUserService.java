package com.njwb.joybeans.service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.util.PageModel;

/**
 * 普通用户的业务操作层
 * 
 * @author soft01
 * 
 */
public interface JoyBeansUserService {

	/**
	 * 分页查询所有的乐豆用户
	 * 
	 * @return
	 * @throws BeanException
	 */
	PageModel<JoyBeansUser> queryAll(int pageNo, int pageSize, String userName, String userAccount, String userPhone) throws JoybeansException;

	/**
	 * 用户登陆乐豆游戏系统
	 * 
	 * @param account
	 * @param pwd
	 * @return
	 * @throws BeanException
	 */
	JoyBeansUser loginByAccountPwd(String userAccount, String userPwd) throws JoybeansException;

	/**
	 * 返回登陆时用户的"手机号,验证码"
	 * 
	 * @param userAccount
	 * @return
	 * @throws BeanException
	 */
	String getMessage(String userAccount) throws JoybeansException;

	/**
	 * 查询手机号是否已注册,true表示已注册
	 * 
	 * @return
	 * @throws BeanException
	 */
	boolean phoneIsRegister(String phone) throws JoybeansException;

	/**
	 * 查询用户名是否已存在，true表示已存在
	 * 
	 * @param account
	 * @return
	 * @throws BeanException
	 */
	boolean accountIsExist(String userAccount) throws JoybeansException;

	/**
	 * 乐豆用户注册
	 * 
	 * @param joyBeansUser
	 * @throws BeanException
	 */
	void register(String userName, String userAccount, String userPwd, String userPhone) throws JoybeansException;

	/**
	 * 修改用户的状态
	 * 
	 * @param id
	 * @param userStatus
	 * @throws BeanException
	 */
	void modifyStatus(String id, String userStatus) throws JoybeansException;

	/**
	 * 通过用户账号查询用户的账户额度
	 * 
	 * @param userAccount
	 * @return
	 * @throws JoybeansException
	 */
	JoyBeansUser queryBalanceByAccount(String userAccount) throws JoybeansException;

	/**
	 * 密保卡充值
	 * 
	 * @param secretBalance
	 * @param id
	 * @throws JoybeansException
	 */
	void addSecretBalance(String secretBalance, String userId,String cardNo,String secretId) throws JoybeansException;
}
