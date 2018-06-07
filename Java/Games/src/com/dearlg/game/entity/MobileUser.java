package com.dearlg.game.entity;

/**
 * 移动用户类
 * 
 * @author soft01
 * 
 */
public class MobileUser {
	/**
	 * 手机号码
	 */
	private String number;

	/**
	 * 手机用户名
	 */
	private String name;

	/**
	 * 用户性别
	 */
	private String sex;

	/**
	 * 用户地址
	 */
	private String address;

	/**
	 * 话费
	 */
	private double account;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

}
