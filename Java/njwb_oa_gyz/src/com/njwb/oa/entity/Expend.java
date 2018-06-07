package com.njwb.oa.entity;

public class Expend {
	/**
	 * 报销编号
	 */
	private String expendNo;

	/**
	 * 申请人
	 */
	private String expendName;

	/**
	 * 报销类型的ID
	 */
	private String expendTypeId;

	/**
	 * 报销类型
	 */
	private String expendTypeValue;

	/**
	 * 报销的金额
	 */
	private String expendCount;

	/**
	 * 报销摘要
	 */
	private String expendBz;

	/**
	 * 提交状态
	 */
	private String expendStatus;

	/**
	 * 创建时间
	 */
	private String createTime;

	public String getExpendCount() {
		return expendCount;
	}

	public void setExpendCount(String expendCount) {
		this.expendCount = expendCount;
	}

	public String getExpendNo() {
		return expendNo;
	}

	public void setExpendNo(String expendNo) {
		this.expendNo = expendNo;
	}

	public String getExpendName() {
		return expendName;
	}

	public void setExpendName(String expendName) {
		this.expendName = expendName;
	}

	public String getExpendTypeId() {
		return expendTypeId;
	}

	public void setExpendTypeId(String expendTypeId) {
		this.expendTypeId = expendTypeId;
	}

	public String getExpendTypeValue() {
		return expendTypeValue;
	}

	public void setExpendTypeValue(String expendTypeValue) {
		this.expendTypeValue = expendTypeValue;
	}

	public String getExpendBz() {
		return expendBz;
	}

	public void setExpendBz(String expendBz) {
		this.expendBz = expendBz;
	}

	public String getExpendStatus() {
		return expendStatus;
	}

	public void setExpendStatus(String expendStatus) {
		this.expendStatus = expendStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
