package com.njwb.joybeans.pojo;

/**
 * 配置信息实体类
 * 
 * @author soft01
 * 
 */
public class BeansConfig {
	/**
	 * 表名
	 */
	private String type;

	/**
	 * 状态ID
	 */
	private String keyId;

	/**
	 * 状态值
	 */
	private String pageValue;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getPageValue() {
		return pageValue;
	}

	public void setPageValue(String pageValue) {
		this.pageValue = pageValue;
	}

}
