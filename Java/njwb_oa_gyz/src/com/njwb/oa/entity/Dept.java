package com.njwb.oa.entity;

import java.util.Date;

/**
 * 部门实体类
 * @author Administrator
 *
 */
public class Dept {
	/**
	 * 部门编号
	 */
	private String deptNo;
	
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 部门位置
	 */
	private String deptLoc;
	
	/**
	 * 部门负责人
	 */
	private String deptManager;
	
	/**
	 * 创建时间
	 */
	private Date creatTime;

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public String getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(String deptManager) {
		this.deptManager = deptManager;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
	
	
}
