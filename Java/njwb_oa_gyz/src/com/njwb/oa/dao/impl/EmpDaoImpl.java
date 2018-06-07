package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.EmpDao;
import com.njwb.oa.entity.Emp;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.RowMapper;

public class EmpDaoImpl implements EmpDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryByName(String name) throws SQLException {
		String sql = "select distinct t_emp_name from t_employee where t_emp_name like ? limit 0,10";
		List<String> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return rs.getString("t_emp_name");
			}
		}, ("%" + name + "%"));
		return list;
	}

	@Override
	public void add(Emp emp) throws SQLException {
		String sql = "insert into t_employee(t_emp_no,t_emp_name,t_emp_dept,t_sex,t_education,t_email,t_phone,t_entry_time,t_create_time) values(?,?,?,?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, emp.getEmpNo(), emp.getEmpName(), emp.getDeptNo(), emp.getEmpSex(), emp.getEmpEducation(), emp.getEmpEmail(), emp.getEmpPhone(), emp.getEntryTime());
	}

	@Override
	public void deleteById(String empNo) throws SQLException {
		String sql = "delete from t_employee where t_emp_no=?";
		JdbcTemplate.executeUpdate(sql, empNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<Emp> queryByName(PageModel<Emp> pageModel, String empName, String deptNo) throws SQLException {
		String sql = "select t_emp_no,t_emp_name,t_emp_dept,t_sex,t_entry_time,dept.t_deptname from t_employee,t_dept as dept where t_employee.t_emp_dept = dept.t_deptno and t_emp_name like ? and t_emp_dept like ? limit ?,?";
		List<Emp> empList = JdbcTemplate.executeQuery(sql, new MyRowMapper(), ("%" + empName + "%"), ("%" + deptNo + "%"), (pageModel.getPageNo() - 1) * pageModel.getPageSize(), pageModel
				.getPageSize());
		pageModel.setDataList(empList);
		return pageModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryByNameCnt(String empName, String deptNo) throws SQLException {
		String sql = "select count(0) as cnt from t_employee where t_emp_name like ? and t_emp_dept like ?";// 需要使用别名
		List<Integer> list = JdbcTemplate.executeQuery(sql, new CntRowMapper(), ("%" + empName + "%"), ("%" + deptNo + "%"));
		return list.get(0);
	}

	@Override
	public void modifyEmp(Emp emp) throws SQLException {
		String sql = "update t_employee set t_emp_name=?,t_emp_dept=?,t_sex=?,t_education=?,t_email=?,t_phone=?,t_entry_time=? where t_emp_no=?";
		JdbcTemplate.executeUpdate(sql, emp.getEmpName(), emp.getDeptNo(), emp.getEmpSex(), emp.getEmpEducation(), emp.getEmpEmail(), emp.getEmpPhone(), emp.getEntryTime(), emp.getEmpNo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Emp queryById(String empNo) throws SQLException {
		String sql = "select t_emp_no,t_emp_name,t_emp_dept,t_sex,t_education,t_email,t_phone,t_entry_time,t_create_time from t_employee where t_emp_no=?";
		List<Emp> empList = JdbcTemplate.executeQuery(sql, new EmpMapper(), empNo);
		if (empList.size() > 0) {
			return empList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 内部类 分页查询实体类
	 * 
	 * @author soft01
	 * 
	 */
	private class MyRowMapper implements RowMapper {
		@Override
		public Object mapperObject(ResultSet rs) throws SQLException {
			Emp emp = new Emp();
			emp.setEmpNo(rs.getString("t_emp_no"));
			emp.setEmpName(rs.getString("t_emp_name"));
			emp.setDeptNo(rs.getString("t_emp_dept"));
			emp.setEmpSex(rs.getString("t_sex").equals("1") ? "男" : "女");
			emp.setEntryTime(rs.getString("t_entry_time"));
			emp.setDeptName(rs.getString("t_deptname"));
			return emp;
		}
	}

	/**
	 * 内部类 分页查询总数
	 * 
	 * @author soft01
	 * 
	 */
	private class CntRowMapper implements RowMapper {
		@Override
		public Object mapperObject(ResultSet rs) throws SQLException {
			return rs.getInt("cnt");
		}
	}

}
