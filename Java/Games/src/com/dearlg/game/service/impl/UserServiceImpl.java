package com.dearlg.game.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.dearlg.game.dao.RateRuleDao;
import com.dearlg.game.dao.UserDao;
import com.dearlg.game.entity.MobileUser;
import com.dearlg.game.entity.RateRule;
import com.dearlg.game.entity.User;
import com.dearlg.game.exception.ErrorCode;
import com.dearlg.game.exception.GameException;
import com.dearlg.game.factory.ObjectFactory;
import com.dearlg.game.service.UserService;
import com.dearlg.game.transaction.Transaction;
import com.dearlg.game.util.StringUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao = (UserDao) ObjectFactory.getBean("userDao");
	private RateRuleDao rateRuleDao = (RateRuleDao) ObjectFactory.getBean("rateRuleDao");
	private Transaction tx = (Transaction) ObjectFactory.getBean("tx");

	@Override
	public void userimprt(File file) throws GameException {
		MobileUser mobileUser = new MobileUser();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String str = reader.readLine();
			String[] strs = null;
			tx.begin();
			while (null != str) {
				// 18360922022|弓永壮|男|山西省吕梁市|100
				strs = str.split("\\|");
				if (!userDao.queryByPhone(strs[0])) {
					mobileUser.setNumber(strs[0]);
					mobileUser.setName(strs[1]);
					mobileUser.setSex(strs[2]);
					mobileUser.setAddress(strs[3]);
					mobileUser.setAccount(Double.valueOf(strs[4]));
					userDao.useimport(mobileUser);
				}
				str = reader.readLine();
			}
			tx.commit();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void regist(String number, String password) throws GameException {
		if (StringUtil.isEmpty(number)) {
			throw new GameException(ErrorCode.NUMBER_IS_EMPTY_ERROR, ErrorCode.NUMBER_IS_EMPTY_ERROR_MSG);
		}
		if (StringUtil.isEmpty(password)) {
			throw new GameException(ErrorCode.PASSWORD_IS_EMPTY_ERROR, ErrorCode.PASSWORD_IS_EMPTY_ERROR_MSG);
		}
		if (!number.matches("^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|{1705}\\d{7}$")) {
			throw new GameException(ErrorCode.NUMBER_IS_INVALID_ERROR, ErrorCode.NUMBER_IS_INVALID_ERROR_MSG);
		}
		if (!password.matches("^([0-9]|[a-zA-Z]){6,10}$")) {
			throw new GameException(ErrorCode.PASSWORD_IS_INVALID_ERROR, ErrorCode.PASSWORD_IS_INVALID_ERROR_MSG);
		}
		try {
			if (!userDao.queryByNumber(number)) {
				User user = userDao.queryByNumberPw(number, password);
				if (null == user) {
					throw new GameException(ErrorCode.NUMBER_IS_INVALID_ERROR, ErrorCode.NUMBER_IS_INVALID_ERROR_MSG);
				} else {
					tx.begin();
					userDao.add(user);
					tx.commit();
				}
			} else {
				throw new GameException(ErrorCode.NUMBER_IS_EXIST_ERROR, ErrorCode.NUMBER_IS_EXIST_ERROR_MSG);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public User log(String number, String password) throws GameException {
		if (StringUtil.isEmpty(number)) {
			throw new GameException(ErrorCode.NUMBER_IS_EMPTY_ERROR, ErrorCode.NUMBER_IS_EMPTY_ERROR_MSG);
		}
		if (StringUtil.isEmpty(password)) {
			throw new GameException(ErrorCode.PASSWORD_IS_EMPTY_ERROR, ErrorCode.PASSWORD_IS_EMPTY_ERROR_MSG);
		}
		if (!number.matches("^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|{1705}\\d{7}$")) {
			throw new GameException(ErrorCode.NUMBER_IS_INVALID_ERROR, ErrorCode.NUMBER_IS_INVALID_ERROR_MSG);
		}
		User user = null;
		try {
			user = userDao.logByNumberPW(number, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void modifVirtualAccount(User user, double price) throws GameException {
		try {
			tx.begin();
			userDao.modifyVirtualaccount(user, price);
			user.setVirtualAccount(user.getVirtualAccount() - price);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void modifyAccount(User user, double price) throws GameException {
		try {
			tx.begin();
			userDao.modifyaccount(user, price);
			user.setAccount(user.getAccount() - price);
			RateRule rateRule = rateRuleDao.queryByUser(user);
			userDao.addVirtualaccount(user, price * rateRule.getRate());
			user.setVirtualAccount(user.getVirtualAccount() + price * rateRule.getRate());
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
