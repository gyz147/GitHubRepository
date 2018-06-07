package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Emp;
import com.njwb.oa.util.PageModel;

/**
 * 员工数据操作层
 * 
 * @author soft01
 * 
 */
public interface EmpDao {
	/**
	 * 根据姓名模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	List<String> queryByName(String name) throws SQLException;
	
	/**
	 * 添加员工
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	void add(Emp emp) throws SQLException;

	/**
	 * 删除员工
	 * 
	 * @param deptNo
	 * @throws SQLException
	 */
	void deleteById(String empNo) throws SQLException;

	/**
	 * 通过员工号修改某个员工信息
	 * @param emp
	 * @throws SQLException
	 */
	void modifyEmp(Emp emp) throws SQLException;

	/**
	 * 根据员工ID查询员工
	 * 
	 * @param empID
	 *            员工ID
	 * @return
	 * @throws SQLException
	 */
	Emp queryById(String empNo) throws SQLException;

	/**
	 * 查询员工
	 * 
	 * @param empName
	 * @return
	 * @throws SQLException
	 */
	PageModel<Emp> queryByName(PageModel<Emp> pageModel, String empName, String deptNo) throws SQLException;

	/**
	 * 模糊查询后员工的总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	int queryByNameCnt(String empName, String deptNo) throws SQLException;

}
