package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.UserDao;
import com.njwb.oa.entity.User;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.RowMapper;

public class UserDaoImpl implements UserDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryByName(String name) throws SQLException {
		String sql = "select distinct t_userName from t_user where t_userName like ? limit 0,10";
		List<String> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return rs.getString("t_userName");
			}
		}, ("%" + name + "%"));
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User queryByIDandPwd(String userName, String pwd) throws SQLException {
		User user = null;
		String sql = "select t_user.t_id,t_userName,t_pwd,t_user.t_emp_no,t_role_id,t_emp_name from t_user,t_employee as emp where t_userName=? and t_pwd=? and t_user.t_emp_no=emp.t_emp_no and t_user_status='1'";
		List<User> userlist = JdbcTemplate.executeQuery(sql, new UserMapper(), userName, pwd);
		if (userlist.size() > 0) {
			user = userlist.get(0);
		}
		return user;
	}

	@Override
	public void moidfy(String userName, String pwd) throws SQLException {
		String sql = "update t_user set t_pwd=? where t_userName=?";
		JdbcTemplate.executeUpdate(sql, pwd, userName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<User> queryAll(PageModel<User> pageModel, String userName, String status, String roleID) throws SQLException {
		String sql = "select t_userName,user.t_emp_no,t_emp_name,t_user_status,t_role_id,t_role_name from t_user as user,t_employee as emp,t_role as role where user.t_emp_no=emp.t_emp_no and user.t_role_id=role.t_id and t_userName like ? and t_user_status like ? and t_role_id like ? limit ?,?";
		List<User> userList = JdbcTemplate.executeQuery(sql, new myMapper(), ("%" + userName + "%"), ("%" + status + "%"), ("%" + roleID + "%"), (pageModel.getPageNo() - 1) * pageModel.getPageSize(),
				pageModel.getPageSize());
		pageModel.setDataList(userList);
		return pageModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryAllCnt(String userName, String status, String roleID) throws SQLException {
		String sql = "select count(0) as cnt from t_user where t_userName like ? and t_user_status like ? and t_role_id like ?";
		List<Integer> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return rs.getInt("cnt");
			}
		}, ("%" + userName + "%"), ("%" + status + "%"), ("%" + roleID + "%"));
		return list.get(0);
	}

	@Override
	public void addUser(User user) throws SQLException {
		String sql = "insert into t_user(t_userName,t_pwd,t_emp_no,t_user_status,t_role_id,t_createtime)values(?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, user.getUserName(), user.getPwd(), user.getEmpNo(), user.getUserStatus(), user.getRoleID());
	}

	@Override
	public void deleteUser(String userName) throws SQLException {
		String sql = "delete from t_user where t_userName=?";
		JdbcTemplate.executeUpdate(sql, userName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User queryUser(String userName) throws SQLException {
		String sql = "select t_userName,user.t_emp_no,t_emp_name,t_user_status,t_role_id,t_role_name from t_user as user,t_employee as emp,t_role as role where user.t_emp_no=emp.t_emp_no and user.t_role_id=role.t_id and t_userName=?";
		List<User> userList = JdbcTemplate.executeQuery(sql, new myMapper(), userName);
		if (userList.size() > 0) {
			User user = userList.get(0);
			user.setUserStatus(user.getUserStatus().equals("正常") ? "1" : "0");
			return user;
		} else {
			return null;
		}
	}

	/**
	 * 查询所有用户内部类
	 * 
	 * @author soft01
	 * 
	 */
	private class myMapper implements RowMapper {
		@Override
		public Object mapperObject(ResultSet rs) throws SQLException {
			User user = new User();
			user.setUserName(rs.getString("t_userName"));
			user.setEmpNo(rs.getString("t_emp_no"));
			user.setEmpName(rs.getString("t_emp_name"));
			user.setUserStatus(rs.getString("t_user_status").equals("1") ? "正常" : "注销");
			user.setRoleID(rs.getString("t_role_id"));
			user.setRoleName(rs.getString("t_role_name"));
			return user;
		}
	}

	@Override
	public void modifyUser(User user) throws SQLException {
		String sql = "update t_user set t_emp_no=?,t_user_status=?,t_role_id=? where t_userName=?";
		JdbcTemplate.executeUpdate(sql, user.getEmpNo(), user.getUserStatus(), user.getRoleID(), user.getUserName());
	}
}
