package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.UserDao;
import com.njwb.oa.entity.User;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.UserService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.StringUtil;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private Transaction tx;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<String> queryByName(String name) throws OAException {
		List<String> list = null;
		try {
			list = userDao.queryByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return list;
	}

	@Override
	public User login(String userName, String pwd) throws OAException {
		if (StringUtil.isEmpty(userName)) {
			throw new OAException("用户名不能为空");
		} else if (StringUtil.isEmpty(pwd)) {
			throw new OAException("密码不能为空");
		}
		User user = null;
		try {
			user = userDao.queryByIDandPwd(userName, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return user;
	}

	@Override
	public void modify(String userName, String pwd) throws OAException {
		try {
			tx.begin();
			userDao.moidfy(userName, pwd);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public PageModel<User> queryAll(int pageNo, int pageSize, String userName, String status, String roleID) throws OAException {
		PageModel<User> pageModel = new PageModel<User>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		try {
			userDao.queryAll(pageModel, userName, status, roleID);
			pageModel.setCnt(userDao.queryAllCnt(userName, status, roleID));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return pageModel;
	}

	@Override
	public void addUser(User user) throws OAException {
		try {
			tx.begin();
			userDao.addUser(user);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public void deleteUser(String userName) throws OAException {
		try {
			tx.begin();
			userDao.deleteUser(userName);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public User queryUser(String userName) throws OAException {
		User user = null;
		try {
			user = userDao.queryUser(userName);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return user;
	}

	@Override
	public void modifyUser(User user) throws OAException {
		try {
			tx.begin();
			userDao.modifyUser(user);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}
}
