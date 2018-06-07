package com.njwb.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.RoleDao;
import com.njwb.oa.entity.Role;
import com.njwb.oa.util.JdbcTemplate;

public class RoleDaoImpl implements RoleDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryAll() throws SQLException {
		String sql = "select t_id,t_role_name from t_role";
		List<Role> roleList = JdbcTemplate.executeQuery(sql, new RoleMapper());
		return roleList;
	}

	@Override
	public void addRole(Role role) throws SQLException {
		String sql = "insert into t_role(t_role_name,t_create_time)values(?,now())";
		JdbcTemplate.executeUpdate(sql, role.getRoleName());
	}

	@Override
	public void delRole(String roleID) throws SQLException {
		String sql = "delete from t_role where t_id=?";
		JdbcTemplate.executeUpdate(sql, roleID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Role queryRole(String roleID) throws SQLException {
		String sql = "select t_id,t_role_name from t_role where t_id=?";
		List<Role> roleList = JdbcTemplate.executeQuery(sql, new RoleMapper(), roleID);
		if (roleList.size() > 0) {
			return roleList.get(0);
		}
		return null;
	}

	@Override
	public void modify(Role role) throws SQLException {
		String sql = "update t_role set t_role_name=? where t_id=?";
		JdbcTemplate.executeUpdate(sql, role.getRoleName(), role.getRoleID());
	}
}
