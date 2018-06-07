package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.DeptDao;
import com.njwb.oa.entity.Dept;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.RowMapper;

public class DeptDaoImpl implements DeptDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> queryAll() throws SQLException {
		String sql = "select t_deptno,t_deptname,t_deptloc,t_deptmanager,t_createtime from t_dept";
		List<Dept> deptList = JdbcTemplate.executeQuery(sql, new DeptMapper(), new Object[] {});
		return deptList;
	}

	@Override
	public void add(Dept dept) throws SQLException {
		String sql = "insert into t_dept(t_deptno,t_deptname,t_deptloc,t_deptmanager,t_createtime) values(?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, dept.getDeptNo(), dept.getDeptName(), dept.getDeptLoc(), dept.getDeptManager());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Dept queryById(String deptNo) throws SQLException {
		String sql = "select t_deptno,t_deptname,t_deptloc,t_deptmanager,t_createtime from t_dept where t_deptno = ?";

		List<Dept> deptList = JdbcTemplate.executeQuery(sql, new DeptMapper(), deptNo);
		if (deptList.size() > 0) {
			return deptList.get(0);

		} else {
			return null;
		}
	}

	@Override
	public void deleteById(String deptNo) throws SQLException {
		String sql = "delete from t_dept where t_deptno = ?";
		JdbcTemplate.executeUpdate(sql, deptNo);
	}

	@Override
	public void modify(Dept dept) throws SQLException {
		String sql = "update t_dept set t_deptname=?,t_deptloc=?,t_deptmanager=? where t_deptNo=?";
		JdbcTemplate.executeUpdate(sql, dept.getDeptName(), dept.getDeptLoc(), dept.getDeptManager(), dept.getDeptNo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryCnt() throws SQLException {
		String sql = "select count(0) as cnt from t_dept";// 需要使用别名
		List<Integer> list = JdbcTemplate.executeQuery(sql, new RowMapper() {
			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return Integer.valueOf(rs.getInt("cnt"));
			}
		}, new Object[] {});
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<Dept> queryByPageModel(PageModel<Dept> pageModel) throws SQLException {
		String sql = "select t_deptno,t_deptname,t_deptloc,t_deptmanager,t_createtime from t_dept limit ?,?";
		List<Dept> deptList = JdbcTemplate.executeQuery(sql, new DeptMapper(), (pageModel.getPageNo() - 1) * pageModel.getPageSize(), pageModel.getPageSize());
		// 调用pageModel模型，将deptList存储到模型中
		pageModel.setDataList(deptList);
		return pageModel;
	}
}
