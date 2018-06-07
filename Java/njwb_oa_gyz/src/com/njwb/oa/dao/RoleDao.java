package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Role;

/**
 * 角色数据操作层
 * 
 * @author soft01
 * 
 */
public interface RoleDao {
	/**
	 * 查询所有角色
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Role> queryAll() throws SQLException;

	/**
	 * 添加角色信息
	 * 
	 * @param role
	 * @throws SQLException
	 */
	void addRole(Role role) throws SQLException;

	/**
	 * 删除角色信息
	 * 
	 * @param roleID
	 * @throws SQLException
	 */
	void delRole(String roleID) throws SQLException;

	/**
	 * 修改前的查询
	 * 
	 * @param roleID
	 * @return
	 * @throws SQLException
	 */
	Role queryRole(String roleID) throws SQLException;

	/**
	 * 修改角色信息
	 * 
	 * @param role
	 * @throws SQLException
	 */
	void modify(Role role) throws SQLException;
}
