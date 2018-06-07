package com.njwb.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.User;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.util.PageModel;

/**
 * 用户的业务操作层
 * 
 * @author soft01
 * 
 */
public interface UserService {

	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws OAException;

	/**
	 * 通过用户名和密码登录
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws OAException
	 */
	User login(String userName, String pwd) throws OAException;

	/**
	 * 修改用户的密码
	 * 
	 * @param userName
	 * @param pwd
	 * @throws OAException
	 */
	void modify(String userName, String pwd) throws OAException;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 * @throws OAException
	 */
	PageModel<User> queryAll(int pageNo, int pageSize, String userName, String status, String roleID) throws OAException;

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @throws OAException
	 */
	void addUser(User user) throws OAException;

	/**
	 * 删除用户
	 * 
	 * @param userName
	 * @throws OAException
	 */
	void deleteUser(String userName) throws OAException;

	/**
	 * 查询某个用户
	 * 
	 * @param useName
	 * @return
	 * @throws OAException
	 */
	User queryUser(String userName) throws OAException;

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @throws OAException
	 */
	void modifyUser(User user) throws OAException;
}
