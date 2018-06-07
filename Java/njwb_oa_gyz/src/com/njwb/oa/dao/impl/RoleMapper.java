package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Role;
import com.njwb.oa.util.RowMapper;

public class RoleMapper implements RowMapper {
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Role role = new Role();
		role.setRoleID(rs.getString("t_id"));
		role.setRoleName(rs.getString("t_role_name"));
		return role;
	}
}
