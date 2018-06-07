package com.dearlg.game.entity;

/**
 * 游戏类
 * 
 * @author soft01
 * 
 */
public class Game {
	/**
	 * 游戏编号
	 */
	private String id;

	/**
	 * 游戏名称
	 */
	private String name;

	/**
	 * 游戏类别
	 */
	private String category;

	/**
	 * 话费价格
	 */
	private double RmbPrice;

	/**
	 * 乐豆价格
	 */
	private double virtualPrice;

	/**
	 * 游戏创建的时间
	 */
	private String time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRmbPrice() {
		return RmbPrice;
	}

	public void setRmbPrice(double rmbPrice) {
		RmbPrice = rmbPrice;
	}

	public double getVirtualPrice() {
		return virtualPrice;
	}

	public void setVirtualPrice(double virtualPrice) {
		this.virtualPrice = virtualPrice;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
