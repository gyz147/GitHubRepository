package com.dearlg.game.entity;

public class GameType {
	/**
	 * 类别的编号(自增长)
	 */
	private int id;

	/**
	 * 类别的名称
	 */
	private String name;

	/**
	 * 类别创建的时间
	 */
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
