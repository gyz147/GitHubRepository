package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.DeptDao;
import com.njwb.oa.entity.Dept;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.DeptService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.StringUtil;

public class DeptServiceImpl implements DeptService {
	private DeptDao deptDao;

	private Transaction tx;

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<Dept> queryAll() throws OAException {
		List<Dept> deptList = null;

		try {
			deptList = deptDao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}

		return deptList;
	}

	@Override
	public void add(Dept dept) throws OAException {
		// service层主要做两件事
		// 1.数据校验
		// 1.1基础数据校验 是否为空 长度 匹配正则。。。。。和js校验一样

		// 部门号 非空且长度为5 部门名称 非空

		if (StringUtil.isEmpty(dept.getDeptNo())) {
			throw new OAException("部门号不能为空");

		} else if (dept.getDeptNo().trim().length() != 5) {

			throw new OAException("部门号长度必须为5");

		} else if (StringUtil.isEmpty(dept.getDeptName())) {

			throw new OAException("部门名称不能为空");

		} else {
			try {
				// 1.2 业务流程数据校验 部门编号是否重复 需要查数据库
				// 根据部门编号查询部门信息
				Dept deptFromDB = deptDao.queryById(dept.getDeptNo());

				// 不能调用service中的queryById，service中的方法不能调用含dao操作的service
				if (deptFromDB == null) {// 可用
					tx.begin();
					// 2.调用dao
					deptDao.add(dept);
					tx.commit();

				} else {// 不可用

					throw new OAException("部门编号已经存在");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				tx.rollback();
				throw new OAException("数据库异常");
			}

		}
	}

	@Override
	public void deleteById(String deptNo) throws OAException {
		try {
			tx.begin();
			deptDao.deleteById(deptNo);
			tx.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			throw new OAException("数据库异常");
		}
	}

	@Override
	public Dept queryById(String deptNo) throws OAException {
		Dept dept = null;
		try {
			dept = deptDao.queryById(deptNo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return dept;
	}

	@Override
	public void modify(Dept dept) throws OAException {
		try {
			tx.begin();
			deptDao.modify(dept);
			tx.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public int queryCnt() throws OAException {
		int cnt = 0;// 返回总数
		try {
			cnt = deptDao.queryCnt();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return cnt;
	}

	@Override
	public PageModel<Dept> queryByPageModel(int pageNo, int pageSize) throws OAException {
		PageModel<Dept> pageModel = new PageModel<Dept>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		try {
			pageModel = deptDao.queryByPageModel(pageModel);
			pageModel.setCnt(deptDao.queryCnt());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return pageModel;
	}

}
