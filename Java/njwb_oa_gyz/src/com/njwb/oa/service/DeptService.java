package com.njwb.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Dept;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.util.PageModel;

/**
 * 部门的业务操作层
 * 
 * @author Administrator
 * 
 */
public interface DeptService {
	/**
	 * 查询所有的部门
	 * 
	 * @return
	 * @throws OAException
	 */
	List<Dept> queryAll() throws OAException;

	/**
	 * 添加部门
	 * 
	 * @param dept
	 * @throws OAException
	 */
	void add(Dept dept) throws OAException;

	/**
	 * 删除部门
	 * 
	 * @param deptNo
	 * @throws OAException
	 */
	void deleteById(String deptNo) throws OAException;

	/**
	 * 根据部门编号查询部门
	 * 
	 * @param deptNo
	 * @return
	 * @throws OAException
	 */
	Dept queryById(String deptNo) throws OAException;

	/**
	 * 根据部门编号修改部门
	 * 
	 * @throws SQLException
	 */
	void modify(Dept dept) throws OAException;

	/**
	 * 查询总数
	 * 
	 * @return
	 * @throws OAException
	 */
	int queryCnt() throws OAException;

	/**
	 * 按照分页模型查询数据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws OAException
	 */
	PageModel<Dept> queryByPageModel(int pageNo, int pageSize) throws OAException;
}
