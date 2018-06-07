package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.njwb.oa.dao.MenuDao;
import com.njwb.oa.entity.Menu;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao = null;

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> queryMenu() throws OAException {
		List<Menu> menuList = new ArrayList<Menu>();
		try {
			menuList = menuDao.queryLevelOneMenu();
			for (Menu menu : menuList) {
				List<Menu> menuSonList = new ArrayList<Menu>();
				menuSonList = menuDao.querySonMenuByPid(menu.getMenuID());
				menu.setSonMenuList(menuSonList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	// 思考：假设菜单层级不固定，如何处理？--递归
	@Override
	public List<Menu> queryMenuByRole(String roleID) throws OAException {

		List<Menu> menuList = new ArrayList<Menu>();
		try {
			menuList = menuDao.queryLevelOneMenuByRole(roleID);
			for (Menu menu : menuList) {
				List<Menu> menuSonList = new ArrayList<Menu>();
				menuSonList = menuDao.querySonMenuByPidRole(menu.getMenuID(), roleID);
				menu.setSonMenuList(menuSonList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}
}
