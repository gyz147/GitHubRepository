package com.njwb.oa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.oa.entity.User;

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
		if (uri.contains("login.jsp") || uri.contains("login.do") || uri.contains("getCertPic.do") || uri.contains("control.jsp") || !(uri.endsWith("jsp") || uri.endsWith(".do"))) {
			chain.doFilter(request, response);
		} else {
			User user = (User) request.getSession().getAttribute("user");
			if (null != user) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(contentRootUrl + "/njwb/prompt/control.jsp");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
