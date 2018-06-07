package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.EmpDao;
import com.njwb.oa.entity.Emp;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.EmpService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.PageModel;

public class EmpServiceImpl implements EmpService {
	private EmpDao empDao;

	private Transaction tx;

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<String> queryByName(String name) throws OAException {
		List<String> list = null;
		try {
			list = empDao.queryByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return list;
	}

	@Override
	public void add(Emp emp) throws OAException {
		try {
			tx.begin();
			empDao.add(emp);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(String empNo) throws OAException {
		try {
			tx.begin();
			empDao.deleteById(empNo);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void modifyEmp(Emp emp) throws OAException {
		try {
			tx.begin();
			empDao.modifyEmp(emp);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public PageModel<Emp> queryByName(int pageNo, int pageSize, String empName, String deptNo) throws OAException {
		PageModel<Emp> pageModel = new PageModel<Emp>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		try {
			pageModel = empDao.queryByName(pageModel, empName, deptNo);
			pageModel.setCnt(empDao.queryByNameCnt(empName, deptNo));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return pageModel;
	}

	@Override
	public int queryByNameCnt(String empName, String deptNo) throws OAException {
		int cnt = 0;// 返回总数
		try {
			cnt = empDao.queryByNameCnt(empName, deptNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return cnt;
	}

	@Override
	public Emp queryById(String empNo) throws OAException {
		Emp emp = null;
		try {
			emp = empDao.queryById(empNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return emp;
	}

}
