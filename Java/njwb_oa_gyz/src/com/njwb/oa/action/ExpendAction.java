package com.njwb.oa.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.njwb.oa.entity.Config;
import com.njwb.oa.entity.Expend;
import com.njwb.oa.entity.User;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.ConfigService;
import com.njwb.oa.service.ExpendService;
import com.njwb.oa.service.WorkFlowService;
import com.njwb.oa.util.Constant;
import com.njwb.oa.util.PageModel;

public class ExpendAction {
	private ExpendService expendService = (ExpendService) ApplicationContext.getBean("expendService");

	/**
	 * 模糊查询所有报销人姓名
	 * 
	 * @return
	 */
	public String queryByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		List<String> list = expendService.queryByName(name);
		String names = JSONArray.fromObject(list).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(names);
		return "success";
	}

	/**
	 * 查询所有报销信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConfigService configService = (ConfigService) ApplicationContext.getBean("configService");
		try {
			List<Config> configList = configService.queryValueById(Constant.EXPEND_TYPE);
			request.getSession().setAttribute("expendTypeList", configList);
		} catch (OAException e1) {
			e1.printStackTrace();
		}
		String name = request.getParameter("name");
		String expendType = request.getParameter("expendType");
		String status = request.getParameter("status");
		if (null == name) {
			name = "";
		}
		if (null == expendType) {
			expendType = "";
		}
		if (null == status) {
			status = "";
		}
		request.setAttribute("name", name);
		request.setAttribute("expendType", expendType);
		request.setAttribute("status", status);
		int pageSize = 5;
		int pageNo = PageModel.getPageNoFromFront(request.getParameter("pageNo"));
		PageModel<Expend> pageModel = null;
		try {
			pageModel = expendService.queryExpend(pageNo, pageSize, Constant.EXPEND_TYPE, name, expendType, status);
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
	 * 添加报销信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		int h = expendService.queryExpendNo();
		String expendNo = "BX" + String.valueOf(h + 1);
		String expendName = user.getUserName();
		String expendType = request.getParameter("expendType");
		String expendBz = request.getParameter("expendBz");
		String expendCount = request.getParameter("expendCount");
		String status = request.getParameter("status");
		String userID = request.getParameter("userID");
		Expend expend = new Expend();
		expend.setExpendNo(expendNo);
		expend.setExpendName(expendName);
		expend.setExpendTypeId(expendType);
		expend.setExpendBz(expendBz);
		expend.setExpendCount(expendCount);
		expend.setExpendStatus(status);
		WorkFlowService workFlowService = (WorkFlowService) ApplicationContext.getBean("workFlowService");
		if ("1".equals(status)) {
			workFlowService.addStartNode(201, expend.getExpendNo());
			workFlowService.nextNode(expend.getExpendNo(), 2, userID, "提交", "pass");
		}
		try {
			expendService.addExpend(expend);
			request.setAttribute("operator", Constant.EXPEND_ADD);
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
		String expendNo = request.getParameter("expendNo");
		try {
			expendService.deletExpend(expendNo);
			request.setAttribute("operator", Constant.EXPEND_DEL);
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
		String expendNo = request.getParameter("expendNo");
		Expend expend = null;
		try {
			expend = expendService.queryExpendByNo(Constant.EXPEND_TYPE, expendNo);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("expend", expend);
		return "success";
	}

	/**
	 * 修改报销信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String expendNo = request.getParameter("expendNo");
		String expendName = request.getParameter("expendName");
		String expendType = request.getParameter("expendType");
		String expendBz = request.getParameter("expendBz");
		String expendCount = request.getParameter("expendCount");
		String status = request.getParameter("status");
		String userID = request.getParameter("userID");
		Expend expend = new Expend();
		expend.setExpendNo(expendNo);
		expend.setExpendName(expendName);
		expend.setExpendTypeId(expendType);
		expend.setExpendBz(expendBz);
		expend.setExpendCount(expendCount);
		expend.setExpendStatus(status);
		WorkFlowService workFlowService = (WorkFlowService) ApplicationContext.getBean("workFlowService");
		if ("1".equals(status)) {
			workFlowService.addStartNode(201, expend.getExpendNo());
			workFlowService.nextNode(expend.getExpendNo(), 2, userID, "提交", "pass");
		}
		try {
			expendService.modifyExpend(expend);
			request.setAttribute("operator", Constant.EXPEND_EDIT);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 查询报销信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.queryForUpdate(request, response);
	}
}
