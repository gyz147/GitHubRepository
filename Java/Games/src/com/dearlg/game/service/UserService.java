package com.dearlg.game.service;

import java.io.File;

import com.dearlg.game.entity.User;
import com.dearlg.game.exception.GameException;

/**
 * 用户数据操作接口
 * 
 * @author soft01
 * 
 */
public interface UserService {
	/**
	 * 将移动数据导入到乐豆系统中
	 * 
	 * @param file
	 * @throws GameException
	 */
	public abstract void userimprt(File file) throws GameException;

	/**
	 * 注册
	 * 
	 * @throws GameException
	 */
	public abstract void regist(String number, String password) throws GameException;

	/**
	 * 登录
	 * 
	 * @param number
	 * @param password
	 * @throws GameException
	 */
	public abstract User log(String number, String password) throws GameException;

	/**
	 * 修改用户话费,并赠送乐豆
	 * 
	 * @throws GameException
	 */
	public abstract void modifyAccount(User user,double price) throws GameException;

	/**
	 * 减少用户乐豆余额
	 * 
	 * @throws GameException
	 */
	public abstract void modifVirtualAccount(User user,double price) throws GameException;
	
}
