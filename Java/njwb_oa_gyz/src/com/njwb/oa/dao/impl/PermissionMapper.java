package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Permission;
import com.njwb.oa.util.RowMapper;

public class PermissionMapper implements RowMapper {
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Permission permission = new Permission();
		permission.setId(rs.getString("t_id"));
		permission.setRoleID(rs.getString("t_role_id"));
		permission.setMenuID(rs.getString("t_menu_id"));
		return permission;
	}
}
