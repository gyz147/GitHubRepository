package com.njwb.oa.entity;

public class MenuSon {
	private String menuID;

	private String hrefUrl;

	private String menuName;// 人事管理

	public MenuSon() {
		super();
	}

	public MenuSon(String menuID, String menuName) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "MenuSon [hrefUrl=" + hrefUrl + ", menuID=" + menuID + ", menuName=" + menuName + "]";
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getHrefUrl() {
		return hrefUrl;
	}

	public void setHrefUrl(String hrefUrl) {
		this.hrefUrl = hrefUrl;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
