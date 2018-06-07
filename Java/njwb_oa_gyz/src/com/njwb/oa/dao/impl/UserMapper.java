package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.User;
import com.njwb.oa.util.RowMapper;

public class UserMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		User user = new User();
		user.setID(rs.getString("t_id"));
		user.setUserName(rs.getString("t_userName"));
		user.setPwd(rs.getString("t_pwd"));
		user.setEmpNo(rs.getString("t_emp_no"));
		user.setRoleID(rs.getString("t_role_id"));
		user.setEmpName(rs.getString("t_emp_name"));
		return user;
	}
}
