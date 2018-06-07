package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.WorkFlowNode;
import com.njwb.oa.util.RowMapper;

/**
 * 部门对象转换器
 * 
 * @author Administrator
 * 
 */
public class WorkFlowNodeMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		WorkFlowNode node = new WorkFlowNode();
		node.setId(rs.getInt("id"));
		node.setWorkID(rs.getInt("t_work_id"));
		node.setNodeID(rs.getInt("t_node_id"));
		node.setNodeName(rs.getString("t_node_name"));
		node.setNextNodeOper(rs.getString("t_next_node_oper"));
		node.setWaitingUser(rs.getString("t_waiting_user"));
		node.setCreateTime(rs.getTimestamp("t_create_time"));
		return node;
	}
}
