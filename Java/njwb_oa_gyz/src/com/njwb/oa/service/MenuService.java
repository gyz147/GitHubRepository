package com.njwb.oa.service;

import java.util.List;

import com.njwb.oa.entity.Menu;
import com.njwb.oa.exception.OAException;

public interface MenuService {
	/**
	 * 查询数据库菜单
	 * 
	 * @return
	 * @throws OAException
	 */
	List<Menu> queryMenu() throws OAException;

	/**
	 * 根据角色查询菜单
	 * 
	 * @param roleID
	 * @return
	 * @throws OAException
	 */
	List<Menu> queryMenuByRole(String roleID) throws OAException;
}
