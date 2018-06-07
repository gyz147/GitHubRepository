package com.njwb.oa.entity;

/**
 * 配置信息实体类
 * 
 * @author soft01
 * 
 */
public class Config {
	/**
	 * 字段类型
	 */
	private String tyep;

	/**
	 * 字段ID
	 */
	private String id;

	/**
	 * 字段的值
	 */
	private String value;

	public String getTyep() {
		return tyep;
	}

	public void setTyep(String tyep) {
		this.tyep = tyep;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
