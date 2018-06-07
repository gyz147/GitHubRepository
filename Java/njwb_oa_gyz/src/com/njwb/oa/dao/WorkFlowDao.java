package com.njwb.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.njwb.oa.entity.WorkFlowNode;
import com.njwb.oa.entity.WorkNodeActionPojo;

/**
 * 审批记录数据操作层
 * 
 * @author soft01
 * 
 */
public interface WorkFlowDao {
	/**
	 * 查看当前编号所有审批记录
	 * 
	 * @param workID
	 * @param tableID
	 * @return
	 * @throws SQLException
	 */
	List<WorkNodeActionPojo> queryHistoryByTableIDWorkID(String workID, String tableID) throws SQLException;

	/**
	 * 查看审批节点的配置信息
	 * 
	 * @param nodeID
	 * @return
	 * @throws SQLException
	 */
	WorkFlowNode queryNodeByNodeID(int nodeID) throws SQLException;

	/**
	 * 查看该用户所有待审批记录
	 * 
	 * @param tableID
	 * @param workID
	 * @return
	 * @throws SQLException
	 */
	List<WorkNodeActionPojo> queryCurrentAction(int waitingUserID,int workID) throws SQLException;
	
	/**
	 * 查看当前审批节点
	 * @param tableID
	 * @param workID
	 * @return
	 * @throws SQLException
	 */
	WorkNodeActionPojo queryCurrentAction(String tableID, String workID) throws SQLException;
	
	/**
	 * 查看当前审批节点
	 * @param tableID
	 * @param workID
	 * @return
	 * @throws SQLException
	 */
	WorkNodeActionPojo queryCurrentAction(String tableID, int workID) throws SQLException;

	void addActionPojo(WorkNodeActionPojo actionPojo) throws SQLException;

	void updateCurrentAction(WorkNodeActionPojo actionPojo) throws SQLException;

	List<String> queryEmpNameByIDs(String ids) throws SQLException;
}
