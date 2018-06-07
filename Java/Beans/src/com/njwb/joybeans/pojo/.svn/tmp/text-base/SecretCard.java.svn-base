package com.njwb.joybeans.pojo;

import java.util.Date;

import com.njwb.joybeans.util.DateUtil;

/**
 * 密保卡实体类
 * 
 * @author soft01
 * 
 */
public class SecretCard {
	/**
	 * 密报卡ID
	 */
	private String id;

	/**
	 * 卡号
	 */
	private String cardNo;

	/**
	 * 密码
	 */
	private String cardPwd;

	/**
	 * 金额
	 */
	private String beansNumbers;

	/**
	 * 省份ID
	 */
	private String cardProv;

	/**
	 * 省份名
	 */
	private String provName;

	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	/**
	 * 状态
	 */
	private String cardStatus;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardPwd() {
		return cardPwd;
	}

	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}

	public String getBeansNumbers() {
		return beansNumbers;
	}

	public void setBeansNumbers(String beansNumbers) {
		this.beansNumbers = beansNumbers;
	}

	public String getCardProv() {
		return cardProv;
	}

	public void setCardProv(String cardProv) {
		this.cardProv = cardProv;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getStartTime() {
		return DateUtil.date2Str(startTime, "yyyy-MM-dd");
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return DateUtil.date2Str(endTime, "yyyy-MM-dd");
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCardStatus() {
		if("1".equals(cardStatus)){
			return "正常";
		}else if("2".equals(cardStatus)){
			return "已使用";
		}else if ("3".equals(cardStatus)) {
			return "过期";
		}
		return "";
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getCreateTime() {
		return DateUtil.date2Str(createTime, "yyyy-MM-dd");
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
