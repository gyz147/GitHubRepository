package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.ExpendDao;
import com.njwb.oa.entity.Expend;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.ExpendService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.PageModel;

public class ExpendServiceImpl implements ExpendService {
	private ExpendDao expendDao;
	private Transaction tx;

	public void setExpendDao(ExpendDao expendDao) {
		this.expendDao = expendDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<String> queryByName(String name) throws OAException {
		List<String> list = null;
		try {
			list = expendDao.queryByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return list;
	}

	@Override
	public PageModel<Expend> queryExpend(int pageNo, int pageSize, String configType, String name, String type, String status) throws OAException {
		PageModel<Expend> pageModel = new PageModel<Expend>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		try {
			expendDao.queryExpend(pageModel, configType, name, type, status);
			pageModel.setCnt(expendDao.queryExpendCnt(name, type, status));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return pageModel;
	}

	@Override
	public void addExpend(Expend expend) throws OAException {
		try {
			tx.begin();
			expendDao.addExpend(expend);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public int queryExpendNo() throws OAException {
		int expendNo = 1000;
		try {
			int cnt = expendDao.queryExpendCnt("", "", "");
			if (cnt == 0) {
				expendNo = 1000;
			} else {
				expendNo = expendDao.queryExpendNo(cnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return expendNo;
	}

	@Override
	public void deletExpend(String expendNo) throws OAException {
		try {
			tx.begin();
			expendDao.deletExpend(expendNo);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public Expend queryExpendByNo(String configType, String expendNo) throws OAException {
		Expend expend = null;
		try {
			expend = expendDao.queryExpendByNo(configType, expendNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return expend;
	}

	@Override
	public void modifyExpend(Expend expend) throws OAException {
		try {
			tx.begin();
			expendDao.modifyExpend(expend);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}
}
