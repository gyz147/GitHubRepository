package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Emp;
import com.njwb.oa.util.RowMapper;

public class EmpMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpNo(rs.getString("t_emp_no"));
		emp.setEmpName(rs.getString("t_emp_name"));
		emp.setDeptNo(rs.getString("t_emp_dept"));
		emp.setEmpSex(rs.getString("t_sex").equals("1") ? "男":"女");
		emp.setEmpEducation(rs.getString("t_education"));
		emp.setEmpEmail(rs.getString("t_email"));
		emp.setEmpPhone(rs.getString("t_phone"));
		emp.setEntryTime(rs.getString("t_entry_time"));
		emp.setCreatTime(rs.getString("t_create_time"));
		return emp;
	}

}
