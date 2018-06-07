package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.njwb.oa.entity.Holiday;
import com.njwb.oa.util.RowMapper;

public class HolidayMapper implements RowMapper {
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Holiday holiday = new Holiday();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		holiday.setHolidayNo(rs.getString("t_holiday_no"));
		holiday.setHolidayName(rs.getString("t_holiday_user"));
		holiday.setHolidayTypeId(rs.getString("t_holiday_type"));
		holiday.setHolidayTypeValue(rs.getString("t_value"));
		holiday.setHolidayBz(rs.getString("t_holiday_bz"));
		try {
			holiday.setStartTime(sdf.parse(rs.getString("t_start_time")));
			holiday.setEndTime(sdf.parse(rs.getString("t_end_time")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		holiday.setCreateTime(rs.getDate("t_createtime"));
		holiday.setHolidayStatus(rs.getString("t_holiday_status").equals("1") ? "已提交" : "草稿");
		return holiday;
	}
}
