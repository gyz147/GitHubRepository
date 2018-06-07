package com.njwb.joybeans.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.Province;
import com.njwb.joybeans.pojo.SecretCard;
import com.njwb.joybeans.service.ProvinceService;
import com.njwb.joybeans.service.SecretCardService;
import com.njwb.joybeans.util.Constant;
import com.njwb.joybeans.util.DateUtil;
import com.njwb.joybeans.util.PageModel;

@Controller
@RequestMapping("/secretCard")
public class SecretCardController {
	@Autowired
	private SecretCardService secretCardService;

	@Autowired
	private ProvinceService provinceService;

	@RequestMapping(value = "/queryAll.action", method = { RequestMethod.GET })
	public String queryAll(String pageNo, String cardNo, String provName, String endTime, HttpServletRequest request) throws JoybeansException {
		if (null == pageNo) {
			pageNo = "1";
		}
		if (null == cardNo) {
			cardNo = "";
		}
		if (null == provName) {
			provName = "";
		}
		if (null == endTime) {
			endTime = "";
		}
		int pageSize = 6;
		PageModel<SecretCard> pageModel = secretCardService.queryAllByCondition(Integer.valueOf(pageNo), pageSize, cardNo, provName, DateUtil.str2Date(endTime, "yyyy-MM-dd"));
		request.setAttribute("pageModel", pageModel);
		request.setAttribute("provName", provName);
		request.setAttribute("cardNo", cardNo);
		request.setAttribute("endTime", endTime);
		return "sysUser/secretCard/secretCard";
	}

	@RequestMapping(value = "/queryForAdd.action", method = { RequestMethod.GET })
	public String queryForAdd(HttpSession session) throws JoybeansException {
		List<Province> provinceList = provinceService.queryAllNotSecretCard();
		session.setAttribute("provinceList", provinceList);
		return "sysUser/secretCard/addSecretCard";
	}

	@RequestMapping(value = "/addSecretCard.action", method = { RequestMethod.POST })
	public String addSecretCard(int cardNumbers, String provStr, int beansNumber, String startTime, String endTime, HttpServletRequest request) throws JoybeansException {
		secretCardService.insertSecretCards(cardNumbers, provStr, beansNumber, startTime, endTime);
		request.setAttribute("operator", Constant.SECRET_CARD_ADD);
		return "prompt/success";
	}
}
