package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.PermissionDao;
import com.njwb.oa.entity.Menu;
import com.njwb.oa.entity.Permission;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.PermissionService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.PageModel;

public class PermissionServiceImpl implements PermissionService {
	PermissionDao permissionDao = null;
	Transaction tx = null;

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public PageModel<Permission> queryAllPermission(int pageNo, int pageSize, String roleID, String menuID) throws OAException {
		PageModel<Permission> pageModel = new PageModel<Permission>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		try {
			permissionDao.queryAll(pageModel, roleID, menuID);
			pageModel.setCnt(permissionDao.queryCnt(roleID, menuID));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return pageModel;
	}

	@Override
	public List<Menu> queryAllMenu() throws OAException {
		List<Menu> list = null;
		try {
			list = permissionDao.queryAllMenu();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return list;
	}

	@Override
	public void addPermission(Permission permission) throws OAException {
		try {
			tx.begin();
			permissionDao.addPermission(permission);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public void deletePermission(String id) throws OAException {
		try {
			tx.begin();
			permissionDao.deletePermission(id);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public Permission queryPermission(String id) throws OAException {
		Permission permission = null;
		try {
			permission = permissionDao.queryPermission(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return permission;
	}

	@Override
	public void modifyPermission(Permission permission) throws OAException {
		try {
			tx.begin();
			permissionDao.modifyPermission(permission);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}
}
