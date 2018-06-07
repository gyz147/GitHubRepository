package com.njwb.joybeans.pojo.wrapper;

import java.util.Date;

/*
 * 消费记录实体类
 */
public class ConsumeRecordWrapper {
	/**
	 * 数据ID
	 */
	private int id;

	/**
	 * 游戏ID
	 */
	private String gameId;

	/**
	 * 游戏名称
	 */
	private String gameName;

	/**
	 * 游戏图片
	 */
	private String picture;

	/**
	 * 乐豆用户ID
	 */
	private String consumerId;

	/**
	 * 购买金额
	 */
	private double price;

	/**
	 * 购买类型
	 */
	private String buyType;

	/**
	 * 赠送的乐豆
	 */
	private double sendBeans;

	/**
	 * 游戏购买的时间
	 */
	private Date createTime;

	/**
	 * 下载次数
	 */
	private int downCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}

	public double getSendBeans() {
		return sendBeans;
	}

	public void setSendBeans(double sendBeans) {
		this.sendBeans = sendBeans;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

}
