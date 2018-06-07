package com.njwb.oa.entity;

/**
 * 用户实体类
 * 
 * @author soft01
 * 
 */
public class User {
	/**
	 * 用户ID
	 */
	private String ID;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String pwd;

	/**
	 * 用户创建时间
	 */
	private String createtime;

	/**
	 * 用户所属员工编号
	 */
	private String empNo;

	/**
	 * 用户的姓名
	 */
	private String empName;

	/**
	 * 用户所属角色的ID
	 */
	private String roleID;

	/**
	 * 用户所属的角色
	 */
	private String roleName;

	/**
	 * 用户的状态
	 */
	private String userStatus;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
