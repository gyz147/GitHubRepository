package com.njwb.oa.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.njwb.oa.entity.Dept;
import com.njwb.oa.entity.Emp;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.DeptService;
import com.njwb.oa.service.EmpService;
import com.njwb.oa.util.Constant;
import com.njwb.oa.util.PageModel;

/**
 * 处理员工相关操作的请求
 * 
 * @author soft01
 * 
 */
public class EmpAction {
	private EmpService empService = (EmpService) ApplicationContext.getBean("empService");
	
	/**
	 * 模糊查询所有员工姓名
	 * 
	 * @return
	 */
	public String queryByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		List<String> list = empService.queryByName(name);
		String names = JSONArray.fromObject(list).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(names);
		return "success";
	}

	/**
	 * 查询所有员工信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DeptService deptService = (DeptService) ApplicationContext.getBean("deptService");
		try {
			List<Dept> deptList = deptService.queryAll();
			request.getSession().setAttribute("deptList", deptList);
		} catch (OAException e) {
			e.printStackTrace();
		}
		String empName = request.getParameter("empName");
		String deptNo = request.getParameter("deptNo");
		if (null == empName) {
			empName = "";
		}
		if (null == deptNo) {
			deptNo = "";
		}
		request.setAttribute("deptNo", deptNo);
		request.setAttribute("empName", empName);
		int pageSize = 5;
		int pageNo = PageModel.getPageNoFromFront(request.getParameter("pageNo"));
		PageModel<Emp> pageModel = null;
		try {
			pageModel = empService.queryByName(pageNo, pageSize, empName, deptNo);
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
	 * 添加员工信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empNo = request.getParameter("empNo");
		String empName = request.getParameter("empName");
		String empDept = request.getParameter("empDept");
		String sex = request.getParameter("sex");
		String education = request.getParameter("education");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String entryTime = request.getParameter("entryTime");
		Emp emp = new Emp();
		emp.setEmpNo(empNo);
		emp.setEmpName(empName);
		emp.setDeptNo(empDept);
		emp.setEmpSex(sex);
		emp.setEmpEducation(education);
		emp.setEmpEmail(email);
		emp.setEmpPhone(phone);
		emp.setEntryTime(entryTime);
		try {
			empService.add(emp);
			request.setAttribute("operator", Constant.EMP_ADD);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 删除员工信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empNo = request.getParameter("empNo");
		try {
			empService.deleteById(empNo);
			request.setAttribute("operator", Constant.EMP_DEL);
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
		String empNo = request.getParameter("empNo");
		Emp emp = null;
		try {
			emp = empService.queryById(empNo);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("emp", emp);
		return "success";
	}

	/**
	 * 修改员工信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Emp emp = new Emp();
		emp.setEmpNo(request.getParameter("empNo"));
		emp.setEmpName(request.getParameter("empName"));
		emp.setDeptNo(request.getParameter("empDept"));
		emp.setEmpSex(request.getParameter("empSex"));
		emp.setEmpEducation(request.getParameter("education"));
		emp.setEmpEmail(request.getParameter("email"));
		emp.setEmpPhone(request.getParameter("phone"));
		emp.setEntryTime(request.getParameter("entryTime"));
		try {
			empService.modifyEmp(emp);
			request.setAttribute("operator", Constant.EMP_EDIT);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 查询员工信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.queryForUpdate(request, response);
	}
}
