package com.njwb.oa.service;

import java.util.List;

import com.njwb.oa.entity.Menu;
import com.njwb.oa.entity.Permission;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.util.PageModel;

/**
 * 权限信息业务操作层
 * 
 * @author soft01
 * 
 */
public interface PermissionService {

	/**
	 * 查询所有权限信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param roleID
	 * @param menuID
	 * @return
	 * @throws OAException
	 */
	PageModel<Permission> queryAllPermission(int pageNo, int pageSize, String roleID, String menuID) throws OAException;

	/**
	 * 查询所有的菜单
	 * 
	 * @return
	 * @throws OAException
	 */
	List<Menu> queryAllMenu() throws OAException;

	/**
	 * 添加权限信息
	 * 
	 * @param permission
	 * @throws OAException
	 */
	void addPermission(Permission permission) throws OAException;

	/**
	 * 删除权限信息
	 * 
	 * @param id
	 * @throws OAException
	 */
	void deletePermission(String id) throws OAException;

	/**
	 * 查询某个权限信息
	 * 
	 * @param id
	 * @return
	 * @throws OAException
	 */
	Permission queryPermission(String id) throws OAException;

	/**
	 * 修改权限信息
	 * 
	 * @param permission
	 * @throws OAException
	 */
	void modifyPermission(Permission permission) throws OAException;
}
