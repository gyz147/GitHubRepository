package com.njwb.joybeans.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njwb.joybeans.pojo.SysUser;
import com.njwb.joybeans.service.SysUserService;
import com.njwb.joybeans.util.Constant;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(value = "/getCode.action", method = { RequestMethod.GET })
	public void getCode(String account, HttpServletResponse response) throws Exception {
		String message = sysUserService.getMessage(account);
		String messages = JSONArray.fromObject(message.split(",")).toString();
		response.getWriter().write(messages);
	}

	@RequestMapping(value = "/login.action", method = { RequestMethod.POST })
	public String login(String account, String password, HttpSession session,HttpServletRequest request) throws Exception {
		SysUser sysUser = sysUserService.login(account, password);
		if (null == sysUser) {
			request.setAttribute("operator", Constant.SYSUSER_LOGIN_ERROR);
			return "prompt/success";
		} else {
			session.setAttribute("sysUser", sysUser);
			request.setAttribute("operator", Constant.SYSUSER_LOGIN_SUCCESS);
			return "prompt/success";
		}
	}

}
