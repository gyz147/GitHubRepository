package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.Dept;
import com.njwb.oa.util.PageModel;

/**
 * 部门数据操作层
 * 
 * @author Administrator
 * 
 */
public interface DeptDao {
	/**
	 * 查询所有部门
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Dept> queryAll() throws SQLException;

	/**
	 * 添加部门
	 * 
	 * @param dept
	 * @throws SQLException
	 */
	void add(Dept dept) throws SQLException;

	/**
	 * 根据部门号查询部门
	 * 
	 * @param deptNo
	 * @return
	 * @throws SQLException
	 */
	Dept queryById(String deptNo) throws SQLException;

	/**
	 * 根据部门号删除部门
	 * 
	 * @param deptNo
	 * @throws SQLException
	 */
	void deleteById(String deptNo) throws SQLException;

	/**
	 * 根据部门编号修改部门
	 * 
	 * @throws SQLException
	 */
	void modify(Dept dept) throws SQLException;

	/**
	 * 查询有多少个部门
	 * 
	 * @return
	 * @throws SQLException
	 */
	int queryCnt() throws SQLException;

	/**
	 * 按照分页模型 查询
	 * 
	 * @param pageModel
	 *            service传递到dao时pageModel中肯定要有pageNo和pageSize 但是dataList没有值
	 * @return pageModel经过dao的查询，将dept的集合数据存储到pageModel中的dataList
	 * @throws SQLException
	 */
	PageModel<Dept> queryByPageModel(PageModel<Dept> pageModel) throws SQLException;
}
