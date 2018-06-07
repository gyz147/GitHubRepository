package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.PermissionDao;
import com.njwb.oa.entity.Menu;
import com.njwb.oa.entity.Permission;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.RowMapper;

public class PermissionDaoImpl implements PermissionDao {
	@SuppressWarnings("unchecked")
	@Override
	public PageModel<Permission> queryAll(PageModel<Permission> pageModel, String roleID, String menuID) throws SQLException {
		String sql = "select p.t_id,t_role_id,t_role_name,t_menu_id,t_menu_name from t_permission as p,t_menu as m,t_role as r where p.t_role_id=r.t_id and p.t_menu_id=m.t_id and p.t_role_id like ? and p.t_menu_id like ? limit ?,?";
		List<Permission> permissionList = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				Permission permission = new Permission();
				permission.setId(rs.getString("t_id"));
				permission.setRoleID(rs.getString("t_role_id"));
				permission.setRoleName(rs.getString("t_role_name"));
				permission.setMenuID(rs.getString("t_menu_id"));
				permission.setMenuName(rs.getString("t_menu_name"));
				return permission;
			}
		}, ("%" + roleID + "%"), ("%" + menuID + "%"), (pageModel.getPageNo() - 1) * pageModel.getPageSize(), pageModel.getPageSize());
		pageModel.setDataList(permissionList);
		return pageModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryCnt(String roleID, String menuID) throws SQLException {
		String sql = "select count(0) as cnt from t_permission where t_role_id like ? and t_menu_id like ?";
		List<Integer> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return rs.getInt("cnt");
			}
		}, ("%" + roleID + "%"), ("%" + menuID + "%"));
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> queryAllMenu() throws SQLException {
		String sql = "select t_id,t_menu_name from t_menu";
		List<Menu> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				Menu menu = new Menu();
				menu.setMenuID(rs.getString("t_id"));
				menu.setMenuName(rs.getString("t_menu_name"));
				return menu;
			}
		});
		return list;
	}

	@Override
	public void addPermission(Permission permission) throws SQLException {
		String sql = "insert into t_permission(t_role_id,t_menu_id,t_create_time)values(?,?,now());";
		JdbcTemplate.executeUpdate(sql, permission.getRoleID(), permission.getMenuID());
	}

	@Override
	public void deletePermission(String id) throws SQLException {
		String sql = "delete from t_permission where t_id=?";
		JdbcTemplate.executeUpdate(sql, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Permission queryPermission(String id) throws SQLException {
		String sql = "select t_id,t_role_id,t_menu_id from t_permission where t_id=?";
		List<Permission> permissionList = JdbcTemplate.executeQuery(sql, new PermissionMapper(), id);
		if (permissionList.size() > 0) {
			return permissionList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void modifyPermission(Permission permission) throws SQLException {
		String sql = "update t_permission set t_menu_id=? where t_id=?";
		JdbcTemplate.executeUpdate(sql, permission.getMenuID(), permission.getId());
	}
}
