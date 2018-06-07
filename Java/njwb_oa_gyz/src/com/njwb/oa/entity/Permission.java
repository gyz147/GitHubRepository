package com.njwb.oa.entity;

/**
 * 权限实体类
 * 
 * @author soft01
 * 
 */
public class Permission {
	/**
	 * 权限ID
	 */
	private String id;

	/**
	 * 角色ID
	 */
	private String roleID;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 菜单ID
	 */
	private String menuID;

	/**
	 * 菜单名称
	 */
	private String menuName;

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
