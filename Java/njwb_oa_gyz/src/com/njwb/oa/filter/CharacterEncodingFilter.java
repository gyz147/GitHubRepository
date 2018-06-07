package com.njwb.oa.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 字符编码过滤器
 * 
 * @author soft01
 * 
 */
public class CharacterEncodingFilter implements Filter {
	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			request.setCharacterEncoding(this.encoding);
		} else {
			request = new MyRequest(request);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

	private class MyRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;

		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		@Override
		public String getParameter(String name) {
			String value = this.request.getParameter(name);
			if (null == value) {
				return null;
			} else {
				try {
					return new String(value.getBytes("iso-8859-1"), CharacterEncodingFilter.this.encoding);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

		@Override
		public String[] getParameterValues(String name) {
			String[] values = this.request.getParameterValues(name);
			if (null == values || values.length == 0) {
				return null;
			} else {
				try {
					for (int i = 0; i < values.length; i++) {
						String value = new String(values[i].getBytes("iso-8859-1"), CharacterEncodingFilter.this.encoding);
						values[i] = value;
					}
					return values;
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
}
