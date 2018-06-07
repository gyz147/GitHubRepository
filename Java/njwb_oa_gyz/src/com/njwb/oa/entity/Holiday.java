package com.njwb.oa.entity;

import java.util.Date;

public class Holiday {
	/**
	 * 请假编号
	 */
	private String holidayNo;

	/**
	 * 请假人
	 */
	private String holidayName;

	/**
	 * 请假类型的ID
	 */
	private String holidayTypeId;

	/**
	 * 请假类型
	 */
	private String holidayTypeValue;

	/**
	 * 请假事由
	 */
	private String holidayBz;

	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	/**
	 * 提交状态
	 */
	private String holidayStatus;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getHolidayNo() {
		return holidayNo;
	}

	public void setHolidayNo(String holidayNo) {
		this.holidayNo = holidayNo;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getHolidayTypeId() {
		return holidayTypeId;
	}

	public void setHolidayTypeId(String holidayTypeId) {
		this.holidayTypeId = holidayTypeId;
	}

	public String getHolidayTypeValue() {
		return holidayTypeValue;
	}

	public void setHolidayTypeValue(String holidayTypeValue) {
		this.holidayTypeValue = holidayTypeValue;
	}

	public String getHolidayBz() {
		return holidayBz;
	}

	public void setHolidayBz(String holidayBz) {
		this.holidayBz = holidayBz;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getHolidayStatus() {
		return holidayStatus;
	}

	public void setHolidayStatus(String holidayStatus) {
		this.holidayStatus = holidayStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
