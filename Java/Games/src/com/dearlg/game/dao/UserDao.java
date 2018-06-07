package com.dearlg.game.dao;

import java.sql.SQLException;

import com.dearlg.game.entity.MobileUser;
import com.dearlg.game.entity.User;

/**
 * 用户数据访问层接口
 * 
 * @author soft01
 * 
 */
public interface UserDao {
	/**
	 * 将移动用户导入到乐豆系统中
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public abstract void useimport(MobileUser mobilUser) throws SQLException;

	/**
	 * 查询移动库 用户表中是否有该号码
	 * 
	 * @param number
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean queryByPhone(String number) throws SQLException;

	/**
	 * 添加用户到数据库中
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public abstract void add(User user) throws SQLException;

	/**
	 * 通过手机号查询该用户是否可以注册，如果可以注册，返回一个用户
	 * 
	 * @param number
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public abstract User queryByNumberPw(String number, String password) throws SQLException;

	/**
	 * 通过手机号查找该用户是否已经注册过
	 * 
	 * @param number
	 * @return
	 * @throws SQLException
	 */
	public abstract boolean queryByNumber(String number) throws SQLException;

	/**
	 * 通过手机号密码登录乐豆系统
	 * 
	 * @param number
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public abstract User logByNumberPW(String number, String password) throws SQLException;

	/**
	 * 修改用户的话费余额
	 */
	public abstract void modifyaccount(User user, double price) throws SQLException;

	/**
	 * 减少用户的乐豆余额
	 */
	public abstract void modifyVirtualaccount(User user, double price) throws SQLException;

	/**
	 * 增加用户的乐豆余额
	 * 
	 * @param user
	 * @param price
	 * @throws SQLException
	 */
	public abstract void addVirtualaccount(User user, double price) throws SQLException;
}
