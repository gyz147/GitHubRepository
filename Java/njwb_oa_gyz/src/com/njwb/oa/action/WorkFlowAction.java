package com.njwb.oa.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.oa.entity.User;
import com.njwb.oa.entity.WorkNodeActionPojo;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.WorkFlowService;

public class WorkFlowAction {

	WorkFlowService workFlowService = (WorkFlowService) ApplicationContext.getBean("workFlowService");

	/**
	 * 查询所有工作流历史记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String queryHistoryAudit(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<WorkNodeActionPojo> historyList = new ArrayList<WorkNodeActionPojo>();
		String tableID = request.getParameter("tableID");
		String workID = request.getParameter("workID");
		historyList = workFlowService.queryHistoryByTableIDWorkID(workID, tableID);
		request.setAttribute("historyList", historyList);
		return "success";
	}

	/**
	 * 查看该用户的待审批记录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String auditBefor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String workID = request.getParameter("workID");
		String waitingUserID = request.getParameter("waitingUserID");
		List<WorkNodeActionPojo> WorkNodeActionPojoList = workFlowService.queryCurrentNode(Integer.valueOf(waitingUserID), Integer.valueOf(workID));
		request.setAttribute("WorkNodeActionPojoList", WorkNodeActionPojoList);
		request.setAttribute("workID", workID);
		return "success";
	}

	/**
	 * 查看当前审批数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String queryAudit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String tableID = request.getParameter("tableID");
		String workID = request.getParameter("workID");
		WorkNodeActionPojo WorkNodeActionPojo = workFlowService.queryCurrentNode(tableID, workID);
		request.setAttribute("WorkNodeActionPojo", WorkNodeActionPojo);
		request.setAttribute("workID", workID);
		return "success";
	}

	public String audit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String workID = request.getParameter("workID");
		String tableID = request.getParameter("tableID");
		String dealAdvices = request.getParameter("dealAdvices");
		String dealType = request.getParameter("dealType");
		String dealUser = ((User) request.getSession().getAttribute("user")).getID();
		try {
			workFlowService.nextNode(tableID, Integer.valueOf(workID), String.valueOf(dealUser), dealAdvices, dealType);
			request.setAttribute("operator", "1000");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("operator", "9999");
		}
		return "success";
	}
}
