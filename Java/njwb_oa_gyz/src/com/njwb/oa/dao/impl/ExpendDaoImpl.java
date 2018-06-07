package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.ExpendDao;
import com.njwb.oa.entity.Expend;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.RowMapper;

public class ExpendDaoImpl implements ExpendDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryByName(String name) throws SQLException {
		String sql = "select distinct t_expend_user from t_expend where t_expend_user like ? limit 0,10";
		List<String> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return rs.getString("t_expend_user");
			}
		}, ("%" + name + "%"));
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<Expend> queryExpend(PageModel<Expend> pageModel, String configType, String name, String type, String status) throws SQLException {
		String sql = "select t_expend_no,t_expend_user,t_expend_type,t_expend_count,t_expend_status,t_expend.t_createtime,config.t_value from t_expend,t_config as config where config.t_type=? and t_expend_type=config.t_keyID and t_expend_user like ? and t_expend_type like ? and t_expend_status like ? limit ?,?";
		List<Expend> expendList = JdbcTemplate.executeQuery(sql, new queryAllMapper(), configType, ("%" + name + "%"), ("%" + type + "%"), ("%" + status + "%"), (pageModel.getPageNo() - 1)
				* pageModel.getPageSize(), pageModel.getPageSize());
		pageModel.setDataList(expendList);
		return pageModel;
	}

	@SuppressWarnings("unchecked")
	public int queryExpendCnt(String name, String type, String status) throws SQLException {
		String sql = "select count(0) as cnt from t_expend where t_expend_user like ? and t_expend_type like ? and t_expend_status like ?";
		List<Integer> list = JdbcTemplate.executeQuery(sql, new CntRowMapper(), ("%" + name + "%"), ("%" + type + "%"), ("%" + status + "%"));
		return list.get(0);
	};

	@Override
	public void addExpend(Expend expend) throws SQLException {
		String sql = "insert into t_expend(t_expend_no,t_expend_user,t_expend_type,t_expend_bz,t_expend_count,t_expend_status,t_createtime)values(?,?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, expend.getExpendNo(), expend.getExpendName(), expend.getExpendTypeId(), expend.getExpendBz(), expend.getExpendCount(), expend.getExpendStatus());
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryExpendNo(int cnt) throws SQLException {
		String sql = "select t_expend_no from t_expend limit ?,?";
		List<Integer> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				String holidayNo = rs.getString("t_expend_no");
				return Integer.valueOf(holidayNo.substring(2));
			}
		}, cnt - 1, cnt);
		return list.get(0);
	}

	@Override
	public void deletExpend(String expendNo) throws SQLException {
		String sql = "delete from t_expend where t_expend_no=?";
		JdbcTemplate.executeUpdate(sql, expendNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Expend queryExpendByNo(String configType, String expendNo) throws SQLException {
		String sql = "select t_expend_no,t_expend_user,t_expend_type,t_expend_bz,t_expend_count,t_expend_status,t_expend.t_createtime,config.t_value from t_expend,t_config as config where config.t_type=? and t_expend_type=config.t_keyID and t_expend_no=?";
		List<Expend> expendList = JdbcTemplate.executeQuery(sql, new ExpendMapper(), configType, expendNo);
		if (expendList.size() > 0) {
			return expendList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void modifyExpend(Expend expend) throws SQLException {
		String sql = "update t_expend set t_expend_user=?,t_expend_type=?,t_expend_bz=?,t_expend_count=?,t_expend_status=? where t_expend_no=?";
		JdbcTemplate.executeUpdate(sql, expend.getExpendName(), expend.getExpendTypeId(), expend.getExpendBz(), expend.getExpendCount(), expend.getExpendStatus(), expend.getExpendNo());
	}

	/**
	 * 查询总报销信息内部类
	 * 
	 * @author soft01
	 * 
	 */
	private class queryAllMapper implements RowMapper {
		@Override
		public Object mapperObject(ResultSet rs) throws SQLException {
			Expend expend = new Expend();
			expend.setExpendNo(rs.getString("t_expend_no"));
			expend.setExpendName(rs.getString("t_expend_user"));
			expend.setExpendTypeId(rs.getString("t_expend_type"));
			expend.setExpendTypeValue(rs.getString("t_value"));
			expend.setExpendCount(rs.getString("t_expend_count"));
			expend.setExpendStatus(rs.getString("t_expend_status").equals("1") ? "已提交" : "草稿");
			expend.setCreateTime(rs.getString("t_createtime"));
			return expend;
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
			return Integer.valueOf(rs.getInt("cnt"));
		}
	}

}
