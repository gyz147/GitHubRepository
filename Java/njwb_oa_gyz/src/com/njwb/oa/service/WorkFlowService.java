package com.njwb.oa.service;

import java.util.List;

import com.njwb.oa.entity.WorkNodeActionPojo;
import com.njwb.oa.exception.OAException;

public interface WorkFlowService {
	/**
	 * 查询审批历史记录
	 * 
	 * @param workID
	 * @param tableID
	 * @return
	 * @throws OA
	 */
	List<WorkNodeActionPojo> queryHistoryByTableIDWorkID(String workID, String tableID) throws OAException;

	/**
	 * 查询所有待审批记录
	 * 
	 * @param tableID
	 * @param workID
	 * @return
	 * @throws OA
	 */
	List<WorkNodeActionPojo> queryCurrentNode(int waitingUserID, int workID) throws OAException;

	/**
	 * 查询当前审批的节点
	 * 
	 * @param tableID
	 * @param workID
	 * @return
	 * @throws OAException
	 */
	public WorkNodeActionPojo queryCurrentNode(String tableID, String workID) throws OAException;

	/**
	 * 关闭当前节点，打开下一节点
	 * 
	 * @param tableID
	 * @param workID
	 * @param dealUser
	 * @param dealAdvices
	 * @param dealType
	 * @throws OAException
	 */
	void nextNode(String tableID, int workID, String dealUser, String dealAdvices, String dealType) throws OAException;

	/**
	 * 添加数据的开始节点
	 * 
	 * @param nodeID
	 * @param tablaID
	 * @throws WbSystemException
	 */
	void addStartNode(int nodeID, String tablaID) throws OAException;
}
