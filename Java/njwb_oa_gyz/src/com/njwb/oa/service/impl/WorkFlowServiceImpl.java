package com.njwb.oa.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.njwb.oa.dao.WorkFlowDao;
import com.njwb.oa.entity.WorkFlowNode;
import com.njwb.oa.entity.WorkNodeActionPojo;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.service.WorkFlowService;
import com.njwb.oa.transaction.Transaction;
import com.njwb.oa.util.StringUtil;

public class WorkFlowServiceImpl implements WorkFlowService {
	private WorkFlowDao workFlowDao;
	private Transaction tx;

	public void setWorkFlowDao(WorkFlowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<WorkNodeActionPojo> queryHistoryByTableIDWorkID(String workID, String tableID) throws OAException {
		try {
			List<WorkNodeActionPojo> list = workFlowDao.queryHistoryByTableIDWorkID(workID, tableID);
			for (WorkNodeActionPojo action : list) {
				action.setStatusName(action.getStatus() == 1 ? "打开" : "关闭");
				WorkFlowNode node = workFlowDao.queryNodeByNodeID(action.getNodeID());
				action.setNodeName(node.getNodeName());
				// 待处理人转换
				action.setWaitingUsersName(getNamesString(action.getWaitingUsers()));
				// 已处理人转换
				action.setDealUserName(getNamesString(action.getDealUser()));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<WorkNodeActionPojo>();
	}

	@Override
	public List<WorkNodeActionPojo> queryCurrentNode(int waitingUserID, int workID) throws OAException {
		List<WorkNodeActionPojo> list = null;
		try {
			list = workFlowDao.queryCurrentAction(waitingUserID, workID);
			for (WorkNodeActionPojo action : list) {
				action.setStatusName(action.getStatus() == 1 ? "打开" : "关闭");
				WorkFlowNode node = workFlowDao.queryNodeByNodeID(action.getNodeID());
				action.setNodeName(node.getNodeName());
				action.setWaitingUsersName(getNamesString(action.getWaitingUsers()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public WorkNodeActionPojo queryCurrentNode(String tableID, String workID) throws OAException {
		WorkNodeActionPojo workNodeActionPojo = null;
		try {
			workNodeActionPojo = workFlowDao.queryCurrentAction(tableID, workID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OAException("数据库异常");
		}
		return workNodeActionPojo;
	}

	public void nextNode(String tableID, int workID, String dealUser, String dealAdvices, String dealType) throws OAException {

		// TODO:如果流程已经结束，则不能审批
		// TODO:权限，操作用户是否在待处理人中？

		// 审核操作：1、关闭当前环节。2、打开下一个环节

		// 关闭当前数据的当前节点
		// 1.查询出当前工作流节点对象

		try {
			WorkNodeActionPojo currentAction = workFlowDao.queryCurrentAction(tableID, workID);
			// 关闭：update原有数据（close_time,deal_user,deal_advice）
			currentAction.setCloseTime(new Date());
			currentAction.setDealUser(dealUser);
			currentAction.setDealAdvices(dealAdvices);
			currentAction.setStatus(0);

			// 打开下一个节点,insert新数据（table_id,node_id,open_time,waiting_user，Status）
			WorkNodeActionPojo nextAction = new WorkNodeActionPojo();
			nextAction.setTableID(tableID);

			// 1.查询出当前节点的节点配置对象node，根据处理类型获取下一个节点ID
			WorkFlowNode currentNode = workFlowDao.queryNodeByNodeID(currentAction.getNodeID());

			int nextNodeID = currentNode.getNextNodeID(dealType);

			nextAction.setNodeID(nextNodeID);
			nextAction.setOpenTime(new Date());

			// 查出下一个节点配置对象，获取待处理人
			WorkFlowNode nextNode = workFlowDao.queryNodeByNodeID(nextNodeID);
			nextAction.setWaitingUsers(nextNode.getWaitingUser());
			nextAction.setStatus(1);

			// TODO 如果下一个节点==结束节点，那么这个节点需要关闭
			if (-1 == nextNode.getNextNodeID("pass")) {
				nextAction.setCloseTime(new Date());
				nextAction.setDealUser(dealUser);
				nextAction.setDealAdvices("工作流结束");
				nextAction.setStatus(2);

			}

			tx.begin();
			// 关闭当前节点
			workFlowDao.updateCurrentAction(currentAction);
			// 添加下一个节点数据
			workFlowDao.addActionPojo(nextAction);

			tx.commit();

		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void addStartNode(int nodeID, String tableID) throws OAException {
		WorkNodeActionPojo actionBean = new WorkNodeActionPojo();
		actionBean.setNodeID(nodeID);
		actionBean.setTableID(tableID);
		actionBean.setOpenTime(new Date());
		actionBean.setCreateTime(new Date());
		actionBean.setStatus(1);
		try {
			tx.begin();
			workFlowDao.addActionPojo(actionBean);
			tx.commit();
		} catch (SQLException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户的ID查询出用户的员工姓名，用于审批历史记录的待处理人，已处理人页面显示
	 * 
	 * @param userIDs
	 *            格式：1,3,34
	 * @return
	 * @throws SQLException
	 */
	private String getNamesString(String userIDs) throws SQLException {
		String names = "";
		if (!StringUtil.isEmpty(userIDs)) {
			try {
				List<String> nameList = workFlowDao.queryEmpNameByIDs(userIDs);
				for (String string : nameList) {
					names += string + ",";
				}
				names = names.substring(0, names.length() - 1);
			} catch (Exception e) {
				System.out.println("查询用户的员工姓名出错：userID:" + userIDs);
				e.printStackTrace();
				names = "";
			}
		}
		return names;
	}
}
