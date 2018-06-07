package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.WorkNodeActionPojo;
import com.njwb.oa.util.RowMapper;

/**
 * 部门对象转换器
 * 
 * @author Administrator
 * 
 */
public class WorkFlowActionMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		WorkNodeActionPojo action = new WorkNodeActionPojo();
		action.setId(rs.getInt("id"));
		action.setNodeID(rs.getInt("t_node_id"));
		action.setTableID(rs.getString("t_table_id"));
		action.setOpenTime(rs.getTimestamp("t_open_time"));
		action.setCloseTime(rs.getTimestamp("t_close_time"));
		action.setStatus(rs.getInt("t_status"));
		action.setWaitingUsers(rs.getString("t_waiting_user"));
		action.setDealUser(rs.getString("t_deal_user"));
		action.setDealAdvices(rs.getString("t_deal_advices"));
		// modify by longhuan 2016-10-27 start------
		// 10-26日，关闭时间页面不现实的原因：closeTime赋值两次
		// action.setCloseTime(rs.getTimestamp("t_create_time"));
		action.setCreateTime(rs.getTimestamp("t_create_time"));
		// modify by longhuan 2016-10-27 end------
		return action;
	}
}
