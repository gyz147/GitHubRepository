package com.njwb.oa.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.oa.entity.Role;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.RoleService;
import com.njwb.oa.util.Constant;

public class RoleAction {
	RoleService roleService = (RoleService) ApplicationContext.getBean("roleService");

	/**
	 * 查询所有报销信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Role> roleList = null;
		try {
			roleList = roleService.queryAll();
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("roleList", roleList);
		return "success";
	}

	/**
	 * 添加报销信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Role role = new Role();
		role.setRoleName(request.getParameter("roleName"));
		try {
			roleService.addRole(role);
			request.setAttribute("operator", Constant.ROLE_ADD);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 删除报销信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String roleID = request.getParameter("roleID");
		try {
			roleService.delRole(roleID);
			request.setAttribute("operator", Constant.ROLE_DEL);
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
		String roleID = request.getParameter("roleID");
		Role role = null;
		try {
			role = roleService.queryRole(roleID);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("role", role);
		return "success";
	}

	/**
	 * 修改角色信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Role role = new Role();
		role.setRoleID(request.getParameter("roleID"));
		role.setRoleName(request.getParameter("roleName"));
		try {
			roleService.modify(role);
			request.setAttribute("operator", Constant.ROLE_EDIT);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}
}
