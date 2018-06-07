package com.njwb.oa.service;

/**
 * 角色操作业务层
 */
import java.util.List;

import com.njwb.oa.entity.Role;
import com.njwb.oa.exception.OAException;

public interface RoleService {
	/**
	 * 查询所有角色信息
	 * 
	 * @return
	 * @throws OAException
	 */
	List<Role> queryAll() throws OAException;

	/**
	 * 添加角色信息
	 * 
	 * @param role
	 * @throws OAException
	 */
	void addRole(Role role) throws OAException;

	/**
	 * 删除角色信息
	 * 
	 * @param roleID
	 * @throws OAException
	 */
	void delRole(String roleID) throws OAException;

	/**
	 * 修改前的查询
	 * 
	 * @param roleID
	 * @throws OAException
	 */
	Role queryRole(String roleID) throws OAException;

	/**
	 * 修改角色信息
	 * 
	 * @param role
	 * @throws OAException
	 */
	void modify(Role role) throws OAException;
}
