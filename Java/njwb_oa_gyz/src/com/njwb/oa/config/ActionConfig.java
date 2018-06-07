package com.njwb.oa.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示action节点
 * @author Administrator
 *
 */
public class ActionConfig {
	/**
	 * 请求的地址  
	 */
	private String name;
	
	/**
	 * 请求对应的处理类
	 */
	private String className;
	
	/**
	 * 请求对应的处理类中的方法名
	 */
	private String methodName;
	
	/**
	 * key是result节点的name值
	 */
	private Map<String, ResultConfig> resultsMap = new HashMap<String, ResultConfig>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Map<String, ResultConfig> getResultsMap() {
		return resultsMap;
	}

	public void setResultsMap(Map<String, ResultConfig> resultsMap) {
		this.resultsMap = resultsMap;
	}
	
	
}
