package com.njwb.oa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.oa.entity.Dept;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.DeptService;
import com.njwb.oa.util.Constant;
import com.njwb.oa.util.PageModel;

/**
 * 处理部门相关操作的请求
 * 
 * @author Administrator
 * 
 */
public class DeptAction {
	private DeptService deptService = (DeptService) ApplicationContext.getBean("deptService");

	/**
	 * 查询所有部门信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DeptService deptService = (DeptService) ApplicationContext.getBean("deptService");
		int pageSize = 5;
		int pageNo = PageModel.getPageNoFromFront(request.getParameter("pageNo"));
		PageModel<Dept> pageModel = null;
		try {
			pageModel = deptService.queryByPageModel(pageNo, pageSize);
			request.setAttribute("pageModel", pageModel);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 添加部门信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		String deptManager = request.getParameter("deptManager");
		Dept dept = new Dept();
		dept.setDeptNo(deptNo);
		dept.setDeptName(deptName);
		dept.setDeptLoc(deptLoc);
		dept.setDeptManager(deptManager);
		try {
			deptService.add(dept);
			request.setAttribute("operator", Constant.DEPT_ADD);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 删除部门信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String deptNo = request.getParameter("deptNo");
		try {
			deptService.deleteById(deptNo);
			request.setAttribute("operator", Constant.DEPT_DEL);
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
		String deptNo = request.getParameter("deptNo");
		Dept dept = null;
		try {
			dept = deptService.queryById(deptNo);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("dept", dept);
		return "success";
	}

	/**
	 * 修改部门信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Dept dept = new Dept();
		dept.setDeptNo(request.getParameter("deptNo"));
		dept.setDeptName(request.getParameter("deptName"));
		dept.setDeptLoc(request.getParameter("deptLoc"));
		dept.setDeptManager(request.getParameter("deptManager"));
		try {
			deptService.modify(dept);
			request.setAttribute("operator", Constant.DEPT_EDIT);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 查询部门信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.queryForUpdate(request, response);
	}
}
