package com.njwb.oa.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.njwb.oa.entity.Emp;
import com.njwb.oa.entity.Menu;
import com.njwb.oa.entity.Role;
import com.njwb.oa.entity.User;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.EmpService;
import com.njwb.oa.service.MenuService;
import com.njwb.oa.service.RoleService;
import com.njwb.oa.service.UserService;
import com.njwb.oa.util.Constant;
import com.njwb.oa.util.MakeCertPic;
import com.njwb.oa.util.PageModel;
import com.njwb.oa.util.StringUtil;

/**
 * 接收用户相关的请求
 * 
 * @author Administrator
 * 
 */
public class UserAction {
	private UserService userService = (UserService) ApplicationContext.getBean("userService");

	/**
	 * 模糊查询所有用户账号
	 * 
	 * @return
	 */
	public String queryByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		List<String> list = userService.queryByName(name);
		String names = JSONArray.fromObject(list).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(names);
		return "success";
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		String code = request.getParameter("code");
		String serverCode = (String) request.getSession().getAttribute("serverCode");
		String result = "";// ajax最终的返回值
		if (StringUtil.isEmpty(userName)) {
			result = Constant.USERNAME_EMPTY;
		} else if (StringUtil.isEmpty(pwd)) {
			result = Constant.PWD_EMPTY;
		} else if (!serverCode.equalsIgnoreCase(code)) {
			result = Constant.CODE_ERROR;
		} else {
			User user = null;
			try {
				user = userService.login(userName, pwd);
				if (user == null) {
					result = Constant.USERNAME_PWD_ERROR;
				} else {
					request.getSession().removeAttribute("serverCode");
					request.getSession().setAttribute("user", user);
					MenuService menuService = (MenuService) ApplicationContext.getBean("menuService");
					List<Menu> menuList = new ArrayList<Menu>();
					menuList = menuService.queryMenuByRole(user.getRoleID());
					request.getSession().setAttribute("MainMenuList", menuList);
					result = Constant.LOGIN_SUCCESS;
				}
			} catch (OAException e) {
				e.printStackTrace();
			}
		}
		response.getWriter().write(result);
		return "login";
	}

	/**
	 * 获取验证码图片
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String getCertPic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OutputStream os = response.getOutputStream();
		String serverCode = MakeCertPic.getCertPic(60, 20, os);
		request.getSession().setAttribute("serverCode", serverCode);
		return "success";
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RoleService roleService = (RoleService) ApplicationContext.getBean("roleService");
		try {
			List<Role> roleList = roleService.queryAll();
			request.getSession().setAttribute("roleList", roleList);
		} catch (OAException e) {
			e.printStackTrace();
		}
		String userName = request.getParameter("userName");
		String status = request.getParameter("status");
		String roleID = request.getParameter("roleID");
		if (null == userName) {
			userName = "";
		}
		if (null == status) {
			status = "";
		}
		if (null == roleID) {
			roleID = "";
		}
		request.setAttribute("userName", userName);
		request.setAttribute("status", status);
		request.setAttribute("roleID", roleID);
		int pageSize = 5;
		int pageNo = PageModel.getPageNoFromFront(request.getParameter("pageNo"));
		PageModel<User> pageModel = null;
		try {
			pageModel = userService.queryAll(pageNo, pageSize, userName, status, roleID);
		} catch (OAException e) {
			e.printStackTrace();
		}
		if (pageModel.getDataList().size() == 0) {
			pageModel.setPageNo2(0);
		}
		request.setAttribute("pageModel", pageModel);
		return "success";
	}

	/**
	 * 添加用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String empNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String status = request.getParameter("status");
		String roleID = request.getParameter("roleID");
		EmpService empService = (EmpService) ApplicationContext.getBean("empService");
		Emp emp = empService.queryById(empNo);
		if (null == emp) {
			request.setAttribute("errorMsg", "添加失败！员工编号有误！");
			return "error";
		} else if (!empName.equals(emp.getEmpName())) {
			request.setAttribute("errorMsg", "添加失败！员工编号与姓名不匹配！");
			return "error";
		} else {
			User user = new User();
			user.setUserName(userName);
			user.setPwd(userName);
			user.setEmpNo(empNo);
			user.setRoleID(roleID);
			user.setUserStatus(status);
			try {
				userService.addUser(user);
				request.setAttribute("operator", Constant.USER_ADD);
				return "success";
			} catch (OAException e) {
				request.setAttribute("errorMsg", e.getMessage());
				return "error";
			}
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		try {
			userService.deleteUser(userName);
			request.setAttribute("operator", Constant.USER_DEL);
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
		String userName = request.getParameter("userName");
		User user = null;
		try {
			user = userService.queryUser(userName);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		return "success";
	}

	/**
	 * 修改用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		String empNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String status = request.getParameter("status");
		String roleID = request.getParameter("roleID");
		EmpService empService = (EmpService) ApplicationContext.getBean("empService");
		Emp emp = empService.queryById(empNo);
		if (null == emp) {
			request.setAttribute("errorMsg", "修改失败！员工编号有误！");
			return "error";
		} else if (!empName.equals(emp.getEmpName())) {
			request.setAttribute("errorMsg", "修改失败！员工编号与姓名不匹配！");
			return "error";
		} else {
			User user = new User();
			user.setUserName(userName);
			user.setEmpNo(empNo);
			user.setRoleID(roleID);
			user.setUserStatus(status);
			try {
				userService.modifyUser(user);
				request.setAttribute("operator", Constant.USER_EDIT);
				return "success";
			} catch (OAException e) {
				request.setAttribute("errorMsg", e.getMessage());
				return "error";
			}
		}
	}
}
