package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.User;
import com.njwb.oa.util.PageModel;

/**
 * 用户数据操作层
 * 
 * @author soft01
 * 
 */
public interface UserDao {
	
	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws SQLException;
	
	/**
	 * 登录系统
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	User queryByIDandPwd(String userName, String pwd) throws SQLException;

	/**
	 * 修改某一个用户的密码
	 * 
	 * @param userName
	 * @param pwd
	 * @throws SQLException
	 */
	void moidfy(String userName, String pwd) throws SQLException;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 * @throws SQLException
	 */
	PageModel<User> queryAll(PageModel<User> pageModel, String userName, String status, String roleID) throws SQLException;

	/**
	 * 模糊用户的总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	int queryAllCnt(String userName, String status, String roleID) throws SQLException;

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @throws SQLException
	 */
	void addUser(User user) throws SQLException;

	/**
	 * 删除用户
	 * 
	 * @param userName
	 * @throws SQLException
	 */
	void deleteUser(String userName) throws SQLException;

	/**
	 * 查询某个用户
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	User queryUser(String userName) throws SQLException;

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @throws SQLException
	 */
	void modifyUser(User user) throws SQLException;
}
