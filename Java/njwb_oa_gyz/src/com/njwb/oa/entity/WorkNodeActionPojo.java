package com.njwb.oa.entity;

import java.util.Date;

public class WorkNodeActionPojo {
	private int id;
	private int nodeID;
	private String nodeName;
	private String tableID;
	private Date openTime;
	private Date closeTime;
	private int status;
	private String statusName;
	private String waitingUsers;
	private String waitingUsersName;
	private String dealUser;
	private String dealUserName;

	private String dealAdvices;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	public String getTableID() {
		return tableID;
	}

	public void setTableID(String tableID) {
		this.tableID = tableID;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getWaitingUsers() {
		return waitingUsers;
	}

	public void setWaitingUsers(String waitingUsers) {
		this.waitingUsers = waitingUsers;
	}

	public String getDealUser() {
		return dealUser;
	}

	public void setDealUser(String dealUser) {
		this.dealUser = dealUser;
	}

	public String getDealAdvices() {
		return dealAdvices;
	}

	public void setDealAdvices(String dealAdvices) {
		this.dealAdvices = dealAdvices;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getWaitingUsersName() {
		return waitingUsersName;
	}

	public void setWaitingUsersName(String waitingUsersName) {
		this.waitingUsersName = waitingUsersName;
	}

	public String getDealUserName() {
		return dealUserName;
	}

	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	@Override
	public String toString() {
		return "WorkNodeActionPojo [closeTime=" + closeTime + ", createTime=" + createTime + ", dealAdvices=" + dealAdvices + ", dealUser=" + dealUser + ", dealUserName=" + dealUserName + ", id="
				+ id + ", nodeID=" + nodeID + ", nodeName=" + nodeName + ", openTime=" + openTime + ", status=" + status + ", statusName=" + statusName + ", tableID=" + tableID + ", waitingUsers="
				+ waitingUsers + ", waitingUsersName=" + waitingUsersName + "]";
	}

}
