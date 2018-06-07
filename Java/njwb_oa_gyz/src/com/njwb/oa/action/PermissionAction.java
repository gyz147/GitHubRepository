package com.njwb.oa.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.oa.entity.Menu;
import com.njwb.oa.entity.Permission;
import com.njwb.oa.entity.Role;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.PermissionService;
import com.njwb.oa.service.RoleService;
import com.njwb.oa.util.Constant;
import com.njwb.oa.util.PageModel;

public class PermissionAction {

	PermissionService permissionService = (PermissionService) ApplicationContext.getBean("permissionService");

	/**
	 * 查询所有权限信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RoleService roleService = (RoleService) ApplicationContext.getBean("roleService");
		List<Role> roleList = roleService.queryAll();
		request.getSession().setAttribute("roleList", roleList);
		List<Menu> menuList = permissionService.queryAllMenu();
		request.getSession().setAttribute("menuList", menuList);
		String roleID = request.getParameter("roleID");
		String menuID = request.getParameter("menuID");
		if (null == roleID) {
			roleID = "";
		}
		if (null == menuID) {
			menuID = "";
		}
		request.setAttribute("roleID", roleID);
		request.setAttribute("menuID", menuID);
		int pageSize = 5;
		int pageNo = PageModel.getPageNoFromFront(request.getParameter("pageNo"));
		PageModel<Permission> pageModel = null;
		try {
			pageModel = permissionService.queryAllPermission(pageNo, pageSize, roleID, menuID);
			if (pageModel.getDataList().size() == 0) {
				pageModel.setPageNo2(0);
			}
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("pageModel", pageModel);
		return "success";
	}

	/**
	 * 添加权限信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String roleID = request.getParameter("roleID");
		String menuID = request.getParameter("menuID");
		Permission permission = new Permission();
		permission.setRoleID(roleID);
		permission.setMenuID(menuID);
		try {
			permissionService.addPermission(permission);
			request.setAttribute("operator", Constant.PERMISSION_ADD);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 删除权限信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		try {
			permissionService.deletePermission(id);
			request.setAttribute("operator", Constant.PERMISSION_DEL);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 修改前查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String queryForUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Permission permission = null;
		try {
			permission = permissionService.queryPermission(id);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("permission", permission);
		return "success";
	}

	/**
	 * 修改权限信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String menuID = request.getParameter("menuID");
		Permission permission = new Permission();
		permission.setId(id);
		permission.setMenuID(menuID);
		try {
			permissionService.modifyPermission(permission);
			request.setAttribute("operator", Constant.PERMISSION_EDIT);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
}
