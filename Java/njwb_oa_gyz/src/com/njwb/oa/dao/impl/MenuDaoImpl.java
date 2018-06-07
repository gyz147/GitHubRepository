package com.njwb.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.MenuDao;
import com.njwb.oa.entity.Menu;
import com.njwb.oa.util.JdbcTemplate;

public class MenuDaoImpl implements MenuDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> queryLevelOneMenu() throws SQLException {
		String sql = " select t_id,t_menu_name, t_href_url, t_parent_id from t_menu where t_parent_id is null";
		List<Menu> menuList = JdbcTemplate.executeQuery(sql, new MenuMapper());
		return menuList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> querySonMenuByPid(String parentID) throws SQLException {
		String sql = " select t_id,t_menu_name, t_href_url, t_parent_id from t_menu where t_parent_id = ?";
		List<Menu> menuList = JdbcTemplate.executeQuery(sql, new MenuMapper(), parentID);
		return menuList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> queryLevelOneMenuByRole(String roleID) throws SQLException {
		String sql = " select t_id,t_menu_name, t_href_url, t_parent_id from t_menu where t_parent_id is null and t_id in (select t_menu_id from t_permission where t_role_id=?)";
		List<Menu> menuList = JdbcTemplate.executeQuery(sql, new MenuMapper(), roleID);
		return menuList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> querySonMenuByPidRole(String parentID, String roleID) throws SQLException {
		// 父节点为当前的一级菜单，并且菜单ID，也必须要在权限表中存在
		// select t_menu_id from t_permissions where t_role_id=2----1,6
		// select * from t_menu where t_parent_id = 1 and id in (1,6);

		String sql = " select t_id,t_menu_name, t_href_url, t_parent_id from t_menu where t_parent_id = ? and t_id in (select t_menu_id from t_permission where t_role_id=?)";
		List<Menu> menuList = JdbcTemplate.executeQuery(sql, new MenuMapper(), parentID, roleID);
		return menuList;
	}

}
