package com.dearlg.game.entity;

/**
 * 下载记录类
 * 
 * @author soft01
 * 
 */
public class DownloadRecord {
	/**
	 * 下载游戏的用户
	 */
	private User user;

	/**
	 * 被下载的游戏
	 */
	private Game game;

	/**
	 * 通过乐豆还是话费购买的
	 */
	private String buyType;

	/**
	 * 通过乐豆或话费买入的价格
	 */
	private double buyPrice;

	/**
	 * 下载游戏的时间
	 */
	private String time;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
