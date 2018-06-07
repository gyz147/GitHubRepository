package com.njwb.oa.entity;

import java.util.List;

/**
 * 菜单实体类
 * 
 * @author soft01
 * 
 */
public class Menu {

	/**
	 * 菜单ID
	 */
	private String menuID;

	/**
	 * 菜单路径
	 */
	private String hrefUrl;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 父菜单ID
	 */
	private String parentID;

	/**
	 * 子菜单集合
	 */
	private List<Menu> sonMenuList;// 部门、员工、请假

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(String menuID, String menuName) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "Menu [hrefUrl=" + hrefUrl + ", menuID=" + menuID + ", menuName=" + menuName + ", parentID=" + parentID + ", sonMenuList=" + sonMenuList + "]";
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

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public List<Menu> getSonMenuList() {
		return sonMenuList;
	}

	public void setSonMenuList(List<Menu> sonMenuList) {
		this.sonMenuList = sonMenuList;
	}

}
