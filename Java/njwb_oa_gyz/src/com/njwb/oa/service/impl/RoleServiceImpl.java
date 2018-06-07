package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.RoleDao;
import com.njwb.oa.entity.Role;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.RoleService;
import com.njwb.oa.transaction.Transaction;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	private Transaction tx;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<Role> queryAll() throws OAException {
		List<Role> roleList = null;
		try {
			roleList = roleDao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return roleList;
	}

	@Override
	public void addRole(Role role) throws OAException {
		try {
			tx.begin();
			roleDao.addRole(role);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public void delRole(String roleID) throws OAException {
		try {
			tx.begin();
			roleDao.delRole(roleID);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public Role queryRole(String roleID) throws OAException {
		Role role = null;
		try {
			role = roleDao.queryRole(roleID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return role;
	}

	@Override
	public void modify(Role role) throws OAException {
		try {
			tx.begin();
			roleDao.modify(role);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}
}
