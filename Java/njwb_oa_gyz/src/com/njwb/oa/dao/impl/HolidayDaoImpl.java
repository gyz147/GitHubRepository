package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.HolidayDao;
import com.njwb.oa.entity.Holiday;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.RowMapper;

public class HolidayDaoImpl implements HolidayDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryByName(String name) throws SQLException {
		String sql = "select distinct t_holiday_user from t_holiday where t_holiday_user like ? limit 0,10";
		List<String> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				return rs.getString("t_holiday_user");
			}
		}, ("%" + name + "%"));
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<Holiday> queryHoliday(PageModel<Holiday> pageModel, String configType, String name, String type, String status) throws SQLException {
		String sql = "select t_holiday_no,t_holiday_user,t_holiday_type,t_holiday_bz,t_start_time,t_end_time,t_holiday_status,t_holiday.t_createtime,config.t_value from t_holiday,t_config as config where config.t_type=? and t_holiday_type=config.t_keyID and t_holiday_user like ? and t_holiday_type like ? and t_holiday_status like ? limit ?,?";
		List<Holiday> holidayList = JdbcTemplate.executeQuery(sql, new HolidayMapper(), configType, ("%" + name + "%"), ("%" + type + "%"), ("%" + status + "%"), (pageModel.getPageNo() - 1)
				* pageModel.getPageSize(), pageModel.getPageSize());
		pageModel.setDataList(holidayList);
		return pageModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryHolidayCnt(String name, String type, String status) throws SQLException {
		String sql = "select count(0) as cnt from t_holiday where t_holiday_user like ? and t_holiday_type like ? and t_holiday_status like ?";
		List<Integer> list = JdbcTemplate.executeQuery(sql, new CntRowMapper(), ("%" + name + "%"), ("%" + type + "%"), ("%" + status + "%"));
		return list.get(0);
	}

	@Override
	public void addHoliday(Holiday holiday) throws SQLException {
		String sql = "insert into t_holiday(t_holiday_no,t_holiday_user,t_holiday_type,t_holiday_bz,t_start_time,t_end_time,t_holiday_status,t_createtime)values(?,?,?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, holiday.getHolidayNo(), holiday.getHolidayName(), holiday.getHolidayTypeId(), holiday.getHolidayBz(), holiday.getStartTime(), holiday.getEndTime(), holiday
				.getHolidayStatus());
	}

	@Override
	public void deletHoliday(String holidayNo) throws SQLException {
		String sql = "delete from t_holiday where t_holiday_no=?";
		JdbcTemplate.executeUpdate(sql, holidayNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Holiday queryHolidayByNo(String configType, String holidayNo) throws SQLException {
		String sql = "select t_holiday_no,t_holiday_user,t_holiday_type,t_holiday_bz,t_start_time,t_end_time,t_holiday_status,t_holiday.t_createtime,config.t_value from t_holiday,t_config as config where config.t_type=? and t_holiday_type=config.t_keyID and t_holiday_no=?";
		List<Holiday> holidayList = JdbcTemplate.executeQuery(sql, new HolidayMapper(), configType, holidayNo);
		if (holidayList.size() > 0) {
			return holidayList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void modifyHoliday(Holiday holiday) throws SQLException {
		String sql = "update t_holiday set t_holiday_user=?,t_holiday_type=?,t_holiday_bz=?,t_start_time=?,t_end_time=?,t_holiday_status=? where t_holiday_no=?";
		JdbcTemplate.executeUpdate(sql, holiday.getHolidayName(), holiday.getHolidayTypeId(), holiday.getHolidayBz(), holiday.getStartTime(), holiday.getEndTime(), holiday.getHolidayStatus(), holiday
				.getHolidayNo());
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

	@SuppressWarnings("unchecked")
	@Override
	public int queryHollidayNo(int cnt) throws SQLException {
		String sql = "select t_holiday_no from t_holiday limit ?,?";
		List<Integer> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				String holidayNo = rs.getString("t_holiday_no");
				return Integer.valueOf(holidayNo.substring(2));
			}
		}, cnt - 1, cnt);
		return list.get(0);
	}

}
