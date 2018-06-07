package com.njwb.oa.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.njwb.oa.entity.Config;
import com.njwb.oa.entity.Holiday;
import com.njwb.oa.entity.User;
import com.njwb.oa.exception.OAException;
import com.njwb.oa.factory.ApplicationContext;
import com.njwb.oa.service.ConfigService;
import com.njwb.oa.service.HolidayService;
import com.njwb.oa.service.WorkFlowService;
import com.njwb.oa.util.Constant;
import com.njwb.oa.util.PageModel;

public class HolidayAction {
	private HolidayService holidayService = (HolidayService) ApplicationContext.getBean("holidayService");

	/**
	 * 模糊查询所有请假人
	 * 
	 * @return
	 */
	public String queryByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		List<String> list = holidayService.queryByName(name);
		String names = JSONArray.fromObject(list).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(names);
		return "success";
	}

	/**
	 * 查询所有请假信息
	 * 
	 * @return
	 */
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConfigService configService = (ConfigService) ApplicationContext.getBean("configService");
		try {
			List<Config> configList = configService.queryValueById(Constant.HOLIDAY_TYPE);
			request.getSession().setAttribute("holidayTypeList", configList);
		} catch (OAException e1) {
			e1.printStackTrace();
		}
		String name = request.getParameter("name");
		String holidayType = request.getParameter("holidayType");
		String status = request.getParameter("status");
		if (null == name) {
			name = "";
		}
		if (null == holidayType) {
			holidayType = "";
		}
		if (null == status) {
			status = "";
		}
		request.setAttribute("name", name);
		request.setAttribute("holidayType", holidayType);
		request.setAttribute("status", status);
		int pageSize = 4;
		int pageNo = PageModel.getPageNoFromFront(request.getParameter("pageNo"));
		PageModel<Holiday> pageModel = null;
		try {
			pageModel = holidayService.queryHoliday(pageNo, pageSize, Constant.HOLIDAY_TYPE, name, holidayType, status);
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
	 * 添加请假信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		int h = holidayService.queryHollidayNo();
		String holidayNo = "QJ" + String.valueOf(h + 1);
		String holidayName = user.getEmpName();
		String holidayType = request.getParameter("holidayType");
		String holidayBz = request.getParameter("holidayBz");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String status = request.getParameter("status");
		String userID = request.getParameter("userID");
		Holiday holiday = new Holiday();
		holiday.setHolidayNo(holidayNo);
		holiday.setHolidayName(holidayName);
		holiday.setHolidayTypeId(holidayType);
		holiday.setHolidayBz(holidayBz);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		holiday.setStartTime(sdf.parse(startTime));
		holiday.setEndTime(sdf.parse(endTime));
		holiday.setHolidayStatus(status);
		WorkFlowService workFlowService = (WorkFlowService) ApplicationContext.getBean("workFlowService");
		if ("1".equals(status)) {
			workFlowService.addStartNode(101, holiday.getHolidayNo());
			workFlowService.nextNode(holiday.getHolidayNo(), 1, userID, "提交", "pass");
		}
		try {
			holidayService.addHoliday(holiday);
			request.setAttribute("operator", Constant.HOLIDAY_ADD);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 删除请假信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String holidayNo = request.getParameter("holidayNo");
		try {
			holidayService.deletHoliday(holidayNo);
			request.setAttribute("operator", Constant.HOLIDAY_DEL);
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
		String holidayNo = request.getParameter("holidayNo");
		Holiday holiday = null;
		try {
			holiday = holidayService.queryHolidayByNo(Constant.HOLIDAY_TYPE, holidayNo);
		} catch (OAException e) {
			e.printStackTrace();
		}
		request.setAttribute("holiday", holiday);
		return "success";
	}

	/**
	 * 修改请假信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String holidayNo = request.getParameter("holidayNo");
		String holidayName = request.getParameter("holidayName");
		String holidayType = request.getParameter("holidayType");
		String holidayBz = request.getParameter("holidayBz");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String status = request.getParameter("status");
		String userID = request.getParameter("userID");
		Holiday holiday = new Holiday();
		holiday.setHolidayNo(holidayNo);
		holiday.setHolidayName(holidayName);
		holiday.setHolidayTypeId(holidayType);
		holiday.setHolidayBz(holidayBz);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		holiday.setStartTime(sdf.parse(startTime));
		holiday.setEndTime(sdf.parse(endTime));
		holiday.setHolidayStatus(status);
		WorkFlowService workFlowService = (WorkFlowService) ApplicationContext.getBean("workFlowService");
		if ("1".equals(status)) {
			workFlowService.addStartNode(101, holiday.getHolidayNo());
			workFlowService.nextNode(holiday.getHolidayNo(), 1, userID, "提交", "pass");
		}
		try {
			holidayService.modifyHoliday(holiday);
			request.setAttribute("operator", Constant.HOLIDAY_EDIT);
			return "success";
		} catch (OAException e) {
			request.setAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	/**
	 * 查询请假信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.queryForUpdate(request, response);
	}
}
