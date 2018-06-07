package com.njwb.joybeans.pojo;

import java.util.Date;

import com.njwb.joybeans.util.DateUtil;

/**
 * 乐豆用户实体类
 * 
 * @author soft01
 * 
 */
public class JoyBeansUser {
	/**
	 * 乐豆用户ID
	 */
	private String id;

	/**
	 * 乐豆用户账号
	 */
	private String userAccount;

	/**
	 * 乐豆用户姓名
	 */
	private String userName;

	/**
	 * 乐豆用户密码
	 */
	private String userPwd;

	/**
	 * 乐豆用户手机号
	 */
	private String userPhone;

	/**
	 * 乐豆用户话费余额
	 */
	private String feeBalance;

	/**
	 * 乐豆用户乐豆余额
	 */
	private String beansBalance;

	/**
	 * 乐豆用户密保余额
	 */
	private String secretBalance;

	/**
	 * 乐豆用户密保卡号
	 */
	private String secretCode;

	/**
	 * 乐豆用户密报卡号
	 */
	private String userStatus;

	/**
	 * 乐豆用户上次修改时间
	 */
	private Date modifyTime;

	/**
	 * 乐豆用户创建时间
	 */
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getFeeBalance() {
		return feeBalance;
	}

	public void setFeeBalance(String feeBalance) {
		this.feeBalance = feeBalance;
	}

	public String getBeansBalance() {
		return beansBalance;
	}

	public void setBeansBalance(String beansBalance) {
		this.beansBalance = beansBalance;
	}

	public String getSecretBalance() {
		return secretBalance;
	}

	public void setSecretBalance(String secretBalance) {
		this.secretBalance = secretBalance;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus.equals("1")?"正常":"暂停使用";
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateTime() {
		return DateUtil.date2Str(createTime, "yyyy-MM-dd");
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
