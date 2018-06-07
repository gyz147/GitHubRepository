package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Menu;
import com.njwb.oa.entity.Permission;
import com.njwb.oa.util.PageModel;

/**
 * 权限数据操作层
 * 
 * @author soft01
 * 
 */
public interface PermissionDao {
	/**
	 * 查询所有权限信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	PageModel<Permission> queryAll(PageModel<Permission> pageModel, String roleID, String menuID) throws SQLException;

	/**
	 * 查询权限信息的总数
	 * 
	 * @param roleID
	 * @param menuID
	 * @return
	 * @throws SQLException
	 */
	int queryCnt(String roleID, String menuID) throws SQLException;

	/**
	 * 查询所有菜单
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Menu> queryAllMenu() throws SQLException;

	/**
	 * 添加权限
	 * 
	 * @param permission
	 * @throws SQLException
	 */
	void addPermission(Permission permission) throws SQLException;

	/**
	 * 删除权限信息
	 * 
	 * @param id
	 * @throws SQLException
	 */
	void deletePermission(String id) throws SQLException;

	/**
	 * 查询某个权限信息
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Permission queryPermission(String id) throws SQLException;

	/**
	 * 修改权限信息
	 * 
	 * @param permission
	 * @throws SQLException
	 */
	void modifyPermission(Permission permission) throws SQLException;

}
