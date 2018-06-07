package com.njwb.joybeans.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njwb.joybeans.pojo.BeansExchange;
import com.njwb.joybeans.service.BeansExchangeService;
import com.njwb.joybeans.service.ProvinceService;
import com.njwb.joybeans.util.Constant;
import com.njwb.joybeans.util.PageModel;

@Controller
@RequestMapping("/beanExchange")
public class BeansExchangeController {
	@Autowired
	private BeansExchangeService beansExchangeService;

	@Autowired
	private ProvinceService provinceService;

	@RequestMapping(value = "/queryAll.action", method = { RequestMethod.GET })
	public String queryAll(String pageNo, String provName, HttpServletResponse response, HttpServletRequest request) throws Exception {
		if (null == pageNo) {
			pageNo = "1";
		}
		if (null == provName) {
			provName = "";
		}
		int pageSize = 6;
		PageModel<BeansExchange> pageModel = beansExchangeService.queryAllByCondition(Integer.valueOf(pageNo), pageSize, provName);
		request.setAttribute("provName", provName);
		request.setAttribute("pageModel", pageModel);
		return "sysUser/beanExchange/beanExchange";
	}

	@RequestMapping(value = "/queryForAdd.action", method = { RequestMethod.GET })
	public void queryForAdd(String provName, HttpServletResponse response) throws Exception {
		List<String> list = provinceService.queryAllNotBeansExchange(provName);
		String names = JSONArray.fromObject(list).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(names);
	}

	@RequestMapping(value = "/addBeanExchange.action", method = { RequestMethod.GET })
	public String addBeanExchange(String provCode, String price, HttpServletRequest request) throws Exception {
		beansExchangeService.addBeanExchange(provCode, price);
		request.setAttribute("operator", Constant.BEANS_EXCHANGE_ADD);
		return "prompt/success";
	}

	@RequestMapping(value = "/queryForUpdate.action", method = { RequestMethod.GET })
	public String queryForUpdate(String id, Model model) throws Exception {
		BeansExchange beansExchange = beansExchangeService.queryById(id);
		model.addAttribute("beansExchange", beansExchange);
		return "sysUser/beanExchange/editBeanExchange";
	}

	@RequestMapping(value = "/editBeanExchange.action", method = { RequestMethod.POST })
	public String editBeanExchange(String id, String price, HttpServletRequest request) throws Exception {
		beansExchangeService.editBeanExchange(id, price);
		request.setAttribute("operator", Constant.BEANS_EXCHANGE_EDIT);
		return "prompt/success";
	}

	@RequestMapping(value = "/deleteBeanExchange.action", method = { RequestMethod.GET })
	public String deleteBeanExchange(String id, HttpServletRequest request) throws Exception {
		beansExchangeService.deleteBeanExchange(id);
		request.setAttribute("operator", Constant.BEANS_EXCHANGE_DEL);
		return "prompt/success";
	}

}
