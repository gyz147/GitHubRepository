package com.dearlg.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.dao.UserDao;
import com.dearlg.game.entity.MobileUser;
import com.dearlg.game.entity.User;
import com.dearlg.game.util.JdbcTemplate;

public class UserDaoImpl implements UserDao {

	@Override
	public void useimport(MobileUser mobielUser) throws SQLException {
		String sql = "insert into t_chinamobile(t_number,t_name,t_sex,t_address,t_account) values(?,?,?,?,?)";
		JdbcTemplate.executeUpdate(sql, mobielUser.getNumber(), mobielUser.getName(), mobielUser.getSex(), mobielUser.getAddress(), mobielUser.getAccount());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean queryByPhone(String number) throws SQLException {
		boolean result = false;
		String sql = "select t_number,t_name,t_sex,t_address,t_account from t_chinamobile where t_number = ?";
		List<MobileUser> MobiluserList = JdbcTemplate.executeQuery(sql, new MobileUserMapper(), number);
		if (MobiluserList.size() > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public void add(User user) throws SQLException {
		String sql = "insert into t_user(t_number,t_name,t_password,t_sex,t_address,t_account,t_VirtualAccount,t_time) values(?,?,?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, user.getNumber(), user.getName(), user.getPassword(), user.getSex(), user.getAddress(), user.getAccount(), user.getVirtualAccount());
	}

	@SuppressWarnings("unchecked")
	@Override
	public User queryByNumberPw(String number, String password) throws SQLException {
		MobileUser mobilUser = null;
		User user = new User();
		String sql = "select t_number,t_name,t_sex,t_address,t_account from t_chinamobile where t_number = ?";
		List<MobileUser> MobiluserList = JdbcTemplate.executeQuery(sql, new MobileUserMapper(), number);
		if (MobiluserList.size() > 0) {
			mobilUser = MobiluserList.get(0);
			user.setNumber(mobilUser.getNumber());
			user.setName(mobilUser.getName());
			user.setPassword(password);
			user.setAccount(mobilUser.getAccount());
			user.setAddress(mobilUser.getAddress());
			user.setSex(mobilUser.getSex());
			user.setVirtualAccount(0);
		} else {
			user = null;
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean queryByNumber(String number) throws SQLException {
		boolean result = false;
		String sql = "select t_number,t_name,t_sex,t_address,t_account,t_password,t_VirtualAccount,t_time from t_user where t_number = ?";
		List<User> userList = JdbcTemplate.executeQuery(sql, new UserMapper(), number);
		if (userList.size() > 0) {
			result = true;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User logByNumberPW(String number, String password) throws SQLException {
		User user = null;
		String sql = "select t_number,t_name,t_sex,t_address,t_account,t_password,t_VirtualAccount,t_time from t_user where t_number = ? and t_password = ?";
		List<User> userList = JdbcTemplate.executeQuery(sql, new UserMapper(), number, password);
		if (userList.size() > 0) {
			user = userList.get(0);
		}
		return user;
	}

	@Override
	public void modifyVirtualaccount(User user, double price) throws SQLException {
		String sql = "update t_user set t_VirtualAccount=t_VirtualAccount-? where t_number=?";
		JdbcTemplate.executeUpdate(sql, price, user.getNumber());
	}

	@Override
	public void modifyaccount(User user, double price) throws SQLException {
		String sql = "update t_user set t_account=t_account-? where t_number=?";
		JdbcTemplate.executeUpdate(sql, price, user.getNumber());
	}

	@Override
	public void addVirtualaccount(User user, double price) throws SQLException {
		String sql = "update t_user set t_VirtualAccount=t_VirtualAccount+? where t_number=?";
		JdbcTemplate.executeUpdate(sql, price, user.getNumber());
	}

}
