package com.njwb.oa.entity;


/**
 * 员工实体类
 * 
 * @author soft01
 * 
 */
public class Emp {
	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 员工编号
	 */
	private String empNo;

	/**
	 * 员工名称
	 */
	private String empName;

	/**
	 * 所属部门
	 */
	private String deptNo;

	/**
	 * 所属部门名称
	 */
	private String deptName;

	/**
	 * 员工性别
	 */
	private String empSex;
	/**
	 * 员工学历
	 */
	private String empEducation;
	/**
	 * email
	 */
	private String empEmail;
	/**
	 * 员工电话
	 */
	private String empPhone;
	/**
	 * 入职时间
	 */
	private String entryTime;

	/**
	 * 创建时间
	 */
	private String creatTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

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

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpEducation() {
		return empEducation;
	}

	public void setEmpEducation(String empEducation) {
		this.empEducation = empEducation;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

}
