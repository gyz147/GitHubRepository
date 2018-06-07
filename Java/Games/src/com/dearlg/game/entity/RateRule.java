package com.dearlg.game.entity;

public class RateRule {
	/**
	 * 用户所处的地区
	 */
	private String address;

	/**
	 * 当地兑换乐豆的比率
	 */
	private double rate;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
