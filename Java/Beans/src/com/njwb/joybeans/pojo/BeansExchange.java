package com.njwb.joybeans.pojo;

import java.util.Date;

import com.njwb.joybeans.util.DateUtil;

/**
 * 乐豆换算比例实体类
 * 
 * @author soft01
 * 
 */
public class BeansExchange {
	/**
	 * 换算比例ID
	 */
	private String id;

	/**
	 * 省份编码
	 */
	private String provCode;

	/**
	 * 省份
	 */
	private String provName;

	/**
	 * 消费金额
	 */
	private String price;

	/**
	 * 更新时间
	 */
	private Date modifyTime;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvCode() {
		return provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getModifyTime() {
		return DateUtil.date2Str(modifyTime, "yyyy-MM-dd");
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateTime() {
		return DateUtil.date2Str(createTime, "yyyy-MM-dd");
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
