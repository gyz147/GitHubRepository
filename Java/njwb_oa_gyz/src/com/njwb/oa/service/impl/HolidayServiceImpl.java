package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.HolidayDao;
import com.njwb.oa.entity.Holiday;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.HolidayService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.PageModel;

public class HolidayServiceImpl implements HolidayService {
	private HolidayDao holidayDao;
	private Transaction tx;

	public void setHolidayDao(HolidayDao holidayDao) {
		this.holidayDao = holidayDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<String> queryByName(String name) throws OAException {
		List<String> list = null;
		try {
			list = holidayDao.queryByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return list;
	}

	@Override
	public PageModel<Holiday> queryHoliday(int pageNo, int pageSize, String configType, String name, String type, String status) throws OAException {
		PageModel<Holiday> pageModel = new PageModel<Holiday>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		try {
			holidayDao.queryHoliday(pageModel, configType, name, type, status);
			pageModel.setCnt(holidayDao.queryHolidayCnt(name, type, status));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return pageModel;
	}

	@Override
	public void addHoliday(Holiday holiday) throws OAException {
		try {
			tx.begin();
			holidayDao.addHoliday(holiday);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public void deletHoliday(String holidayNo) throws OAException {
		try {
			tx.begin();
			holidayDao.deletHoliday(holidayNo);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public Holiday queryHolidayByNo(String configType, String holidayNo) throws OAException {
		Holiday holiday = null;
		try {
			holiday = holidayDao.queryHolidayByNo(configType, holidayNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return holiday;
	}

	@Override
	public void modifyHoliday(Holiday holiday) throws OAException {
		try {
			tx.begin();
			holidayDao.modifyHoliday(holiday);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public int queryHollidayNo() throws OAException {
		int holidayNo = 1000;
		try {
			int cnt = holidayDao.queryHolidayCnt("", "", "");
			if (0 == cnt) {
				holidayNo = 1000;
			} else {
				holidayNo = holidayDao.queryHollidayNo(cnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return holidayNo;
	}
}
