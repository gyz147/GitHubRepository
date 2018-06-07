package com.njwb.oa.dispatcher;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njwb.oa.config.ActionConfig;
import com.njwb.oa.config.ActionMappingConfig;
import com.njwb.oa.config.Configuration;
import com.njwb.oa.config.ResultConfig;

/**
 * 分发器 接收所有以.do结尾的请求
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	private ActionMappingConfig actionMappingConfig;

	// key 是acition的名称 value:action对应的实例
	private Map<String, Object> actionObjMap = new HashMap<String, Object>();

	@Override
	public void init() throws ServletException {
		Configuration configuration = new Configuration();
		this.actionMappingConfig = configuration.parse();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取请求uri http://127.0.0.1:8888/njwb_oa/login.do
		String uri = request.getRequestURI();// /njwb_oa/login.do
		String contentPath = request.getContextPath(); // /njwb_oa
		String actionName = uri.substring(contentPath.length());// /login.do
		actionName = actionName.substring(0, actionName.length() - 3);

		// 通过actionName找具体的那个Action类-----》参考mvc.xml文件
		ActionConfig actionConfig = actionMappingConfig.getActionConfigMap().get(actionName);

		String actionClassName = actionConfig.getClassName();

		try {

			Class actionClass = Class.forName(actionClassName);

			if (!actionObjMap.containsKey(actionName)) {// 首次使用该action
				// 实例化
				Object actionObj = actionClass.newInstance();
				actionObjMap.put(actionName, actionObj);
			}

			String actionMethodName = actionConfig.getMethodName();

			Method method = actionClass.getDeclaredMethod(actionMethodName, HttpServletRequest.class, HttpServletResponse.class);

			// 动态执行method
			// invoke执行完毕，会返回对应的方法的返回值
			String resultString = (String) method.invoke(actionObjMap.get(actionName), request, response);
			// 根据结果处理响应

			ResultConfig resultConfig = actionConfig.getResultsMap().get(resultString);

			String type = resultConfig.getType();
			if ("redirect".equalsIgnoreCase(type)) {// 重定向
				response.sendRedirect(contentPath + resultConfig.getPath());
			} else if ("forward".equalsIgnoreCase(type)) {// 转发
				request.getRequestDispatcher(resultConfig.getPath()).forward(request, response);
			} else {// stream 直接回到浏览器

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
