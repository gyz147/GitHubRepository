package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Menu;

public interface MenuDao {
	/**
	 * 查询数据库一级菜单
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Menu> queryLevelOneMenu() throws SQLException;

	/**
	 * 根据父节点查询子菜单
	 * 
	 * @param parentID
	 * @return
	 * @throws SQLException
	 */
	List<Menu> querySonMenuByPid(String parentID) throws SQLException;

	/**
	 * 根据角色查询一级菜单
	 * 
	 * @param roleID
	 * @return
	 * @throws SQLException
	 */
	List<Menu> queryLevelOneMenuByRole(String roleID) throws SQLException;

	List<Menu> querySonMenuByPidRole(String parentID, String roleID) throws SQLException;
}
