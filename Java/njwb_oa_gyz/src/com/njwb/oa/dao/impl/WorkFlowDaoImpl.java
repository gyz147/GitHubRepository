package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.dao.WorkFlowDao;
import com.njwb.oa.entity.WorkFlowNode;
import com.njwb.oa.entity.WorkNodeActionPojo;
import com.njwb.oa.util.JdbcTemplate;
import com.njwb.oa.util.RowMapper;

public class WorkFlowDaoImpl implements WorkFlowDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkNodeActionPojo> queryHistoryByTableIDWorkID(String workID, String tableID) throws SQLException {
		String sql = "select id,t_node_id,t_table_id,t_open_time,t_close_time,t_status,t_waiting_user,t_deal_user,t_deal_advices,t_create_time from t_work_node_action where t_table_id=? and t_node_id in(select t_node_id	from t_work_node_config where t_work_id=?)";
		List<WorkNodeActionPojo> list = JdbcTemplate.executeQuery(sql, new WorkFlowActionMapper(), tableID, workID);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public WorkFlowNode queryNodeByNodeID(int nodeID) throws SQLException {
		String sql = "select id,t_work_id,t_node_id,t_node_name,t_next_node_oper,t_waiting_user,t_create_time from t_work_node_config where t_node_id=?";
		List<WorkFlowNode> list = JdbcTemplate.executeQuery(sql, new WorkFlowNodeMapper(), nodeID);
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkNodeActionPojo> queryCurrentAction(int waitingUserID, int workID) throws SQLException {
		String sql = "select a.t_node_id,a.t_table_id,c.t_node_name,a.t_status,a.t_open_time,a.t_close_time,a.t_waiting_user from t_work_node_action as a,t_work_node_config as c where a.t_waiting_user=? and a.t_node_id=c.t_node_id and a.t_status=1 and a.t_node_id in(select t_node_id from t_work_node_config where t_work_id=?) order by a.id desc";
		List<WorkNodeActionPojo> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				WorkNodeActionPojo workNodeActionPojo = new WorkNodeActionPojo();
				workNodeActionPojo.setNodeID(rs.getInt("t_node_id"));
				workNodeActionPojo.setTableID(rs.getString("t_table_id"));
				workNodeActionPojo.setNodeName(rs.getString("t_node_name"));
				workNodeActionPojo.setStatus(rs.getInt("t_status"));
				workNodeActionPojo.setOpenTime(rs.getTimestamp("t_open_time"));
				workNodeActionPojo.setCloseTime(rs.getTimestamp("t_close_time"));
				workNodeActionPojo.setWaitingUsers(rs.getString("t_waiting_user"));
				return workNodeActionPojo;
			}
		}, waitingUserID, workID);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public WorkNodeActionPojo queryCurrentAction(String tableID, String workID) throws SQLException {
		String sql = "select a.t_table_id,c.t_node_id,c.t_node_name from t_work_node_action as a,t_work_node_config as c where t_table_id=? and t_work_id=? and a.t_node_id=c.t_node_id  order by a.id desc limit 0,1";
		List<WorkNodeActionPojo> list = JdbcTemplate.executeQuery(sql, new RowMapper() {
			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				WorkNodeActionPojo workNodeActionPojo = new WorkNodeActionPojo();
				workNodeActionPojo.setTableID(rs.getString("t_table_id"));
				workNodeActionPojo.setNodeID(rs.getInt("t_node_id"));
				workNodeActionPojo.setNodeName(rs.getString("t_node_name"));
				return workNodeActionPojo;
			}
		}, tableID, workID);
		return list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public WorkNodeActionPojo queryCurrentAction(String tableID, int workID) throws SQLException {
		String sql = "select * from t_work_node_action where t_table_id=? and t_node_id in( select t_node_id from t_work_node_config where t_work_id=?)order by id desc limit 0,1";
		List<WorkNodeActionPojo> list = JdbcTemplate.executeQuery(sql, new WorkFlowActionMapper(), tableID, workID);
		return list.get(0);
	}

	@Override
	public void addActionPojo(WorkNodeActionPojo actionPojo) throws SQLException {
		// TODO Auto-generated method stub
		// 添加新的工作流记录：table_id,node_id,open_time,waiting_user
		String sql = "insert into t_work_node_action(t_node_id,t_table_id,t_open_time,t_status,t_waiting_user,t_create_time,t_close_time,t_deal_user,t_deal_advices)values(?,?,?,?,?,?,?,?,?)";
		JdbcTemplate.executeUpdate(sql, actionPojo.getNodeID(), actionPojo.getTableID(), actionPojo.getOpenTime(), actionPojo.getStatus(), actionPojo.getWaitingUsers(), actionPojo.getCreateTime(),
				actionPojo.getCloseTime(), actionPojo.getDealUser(), actionPojo.getDealAdvices());

	}

	@Override
	public void updateCurrentAction(WorkNodeActionPojo actionPojo) throws SQLException {
		// TODO Auto-generated method stub
		// 关闭当前节点：修改当前节点数据：close_time,deal_user,deal_advice
		String sql = "update t_work_node_action set t_close_time=?,t_deal_user=?,t_deal_advices=?,t_status=? where id=?";
		JdbcTemplate.executeUpdate(sql, actionPojo.getCloseTime(), actionPojo.getDealUser(), actionPojo.getDealAdvices(), actionPojo.getStatus(), actionPojo.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryEmpNameByIDs(String ids) throws SQLException {
		String sql = "select e.t_emp_name from t_user u ,t_employee e where u.t_emp_no=e.t_emp_no and u.t_id in (" + ids + ")";
		List<String> list = JdbcTemplate.executeQuery(sql, new RowMapper() {

			@Override
			public Object mapperObject(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("t_emp_name");
			}
		}, new Object[] {});
		return list;
	}

}
