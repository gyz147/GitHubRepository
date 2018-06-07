package com.njwb.joybeans.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.njwb.joybeans.pojo.JoyBeansUser;

/**
 * 乐豆用户数据操作层
 * 
 * @author soft01
 * 
 */
public interface JoyBeansUserMapper {

	/**
	 * 用户登陆乐豆游戏系统
	 * 
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	JoyBeansUser loginByAccountPwd(Map<String, String> param) throws Exception;

	/**
	 * 通过账号查询用户的手机号
	 * 
	 * @param userAccount
	 * @return
	 * @throws SQLException
	 */
	String queryPhoneByAccount(String userAccount) throws Exception;

	/**
	 * 按条件查询所有乐豆用户,分页查询
	 * 
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<JoyBeansUser> queryAllByCondition(Map<String, String> param) throws Exception;

	/**
	 * 按条件查询乐豆用户的总数
	 * 
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	int queryCntByCondition(Map<String, String> param) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param joyBeansUser
	 * @throws SQLException
	 */
	void register(JoyBeansUser joyBeansUser) throws Exception;

	/**
	 * 查询该手机号是否注册
	 * 
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	String queryPhoneForRegister(String phone) throws Exception;

	/**
	 * 修改用户状态
	 * 
	 * @param param
	 * @throws SQLException
	 */
	void updateJoyBeansUser(Map<String, String> param) throws Exception;

	/**
	 * 查询用户此时的账户金额
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	JoyBeansUser queryBalance(String userAccount) throws Exception;

	/**
	 * 更改用户密保卡额度
	 * 
	 * @param param
	 * @throws Exception
	 */
	void addSecretBalance(Map<String, String> param) throws Exception;
	
	/**
	 * 修改用户账户额度
	 * 
	 * @param param
	 * @throws Exception
	 */
	void updateBalance(Map<String, Object> param) throws Exception;


}
