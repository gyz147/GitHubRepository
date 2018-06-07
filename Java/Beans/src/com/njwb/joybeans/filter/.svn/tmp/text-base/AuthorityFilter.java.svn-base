package com.njwb.joybeans.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.pojo.SysUser;

/**
 * 登录过滤器
 * 
 * @author soft01
 * 
 */
public class AuthorityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		String contentRootUrl = request.getContextPath();// /njwb_oa
		if (uri.contains("login.jsp") || uri.contains("login.action") || uri.contains("register.jsp") || uri.contains("register.action") || uri.contains("joyBeansUser") || uri.contains("Control.jsp")
				|| uri.endsWith(".action") || !(uri.endsWith(".jsp"))) {
			chain.doFilter(request, response);
		} else if (uri.contains("sysUser")) {
			SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
			if (null != sysUser) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(contentRootUrl + "/beans/prompt/userControl.jsp");
			}
		} else {
			JoyBeansUser joyBeansUser = (JoyBeansUser) request.getSession().getAttribute("joyBeansUser");
			if (null != joyBeansUser) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(contentRootUrl + "/beans/prompt/joyBeansUserControl.jsp");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
