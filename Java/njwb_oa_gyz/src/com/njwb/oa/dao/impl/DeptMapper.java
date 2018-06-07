package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Dept;
import com.njwb.oa.util.RowMapper;
/**
 * 部门对象转换器
 * @author Administrator
 *
 */
public class DeptMapper implements RowMapper{

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Dept dept = new Dept();
		dept.setDeptNo(rs.getString("t_deptno"));
		dept.setDeptName(rs.getString("t_deptname"));
		dept.setDeptLoc(rs.getString("t_deptloc"));
		dept.setDeptManager(rs.getString("t_deptmanager"));
		dept.setCreatTime(rs.getDate("t_createtime"));
		return dept;
	}

}
