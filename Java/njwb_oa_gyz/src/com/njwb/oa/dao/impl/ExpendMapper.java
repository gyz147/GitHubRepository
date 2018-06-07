package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Expend;
import com.njwb.oa.util.RowMapper;

public class ExpendMapper implements RowMapper {
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Expend expend = new Expend();
		expend.setExpendNo(rs.getString("t_expend_no"));
		expend.setExpendName(rs.getString("t_expend_user"));
		expend.setExpendTypeId(rs.getString("t_expend_type"));
		expend.setExpendTypeValue(rs.getString("t_value"));
		expend.setExpendBz(rs.getString("t_expend_bz"));
		expend.setExpendCount(rs.getString("t_expend_count"));
		expend.setExpendStatus(rs.getString("t_expend_status").equals("1") ? "已提交" : "草稿");
		expend.setCreateTime(rs.getString("t_createtime"));
		return expend;
	}
}
