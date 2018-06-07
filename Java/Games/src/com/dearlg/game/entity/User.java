package com.dearlg.game.entity;

/**
 * 乐豆系统用户类
 * 
 * @author soft01
 * 
 */
public class User {
	/**
	 * 手机号码
	 */
	private String number;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 登录密码,不大于十位字母数字组合
	 */
	private String password;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 用户所在地
	 */
	private String address;

	/**
	 * 话费余额
	 */
	private double account;

	/**
	 * 乐豆余额
	 */
	private double VirtualAccount;

	/**
	 * 用户注册时间
	 */
	private String time;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public double getVirtualAccount() {
		return VirtualAccount;
	}

	public void setVirtualAccount(double virtualAccount) {
		VirtualAccount = virtualAccount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
