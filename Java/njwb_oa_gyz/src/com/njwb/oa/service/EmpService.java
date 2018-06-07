package com.njwb.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Emp;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.util.PageModel;

/**
 * 员工的业务操作层
 * 
 * @author soft01
 * 
 */
public interface EmpService {
	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws OAException;
	
	/**
	 * 添加员工
	 * 
	 * @param emp
	 * @throws OAException
	 */
	void add(Emp emp) throws OAException;

	/**
	 * 删除员工
	 * 
	 * @param empNo
	 * @throws OAException
	 */
	void deleteById(String empNo) throws OAException;

	/**
	 * 修改员工
	 * @param emp
	 * @throws OAException
	 */
	void modifyEmp(Emp emp) throws OAException;

	/**
	 * 查询员工
	 * 
	 * @param empName
	 * @return
	 * @throws SQLException
	 */
	PageModel<Emp> queryByName(int pageNo, int pageSize, String empName, String deptNo) throws OAException;

	/**
	 * 模糊查询后员工的总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	int queryByNameCnt(String empName, String deptNo) throws OAException;

	/**
	 * 根据员工ID查询员工
	 * 
	 * @param empID
	 *            员工ID
	 * @return
	 * @throws OAException
	 */
	Emp queryById(String empNo) throws OAException;

}
