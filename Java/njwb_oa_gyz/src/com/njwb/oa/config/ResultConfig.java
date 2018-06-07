package com.njwb.oa.config;
/**
 * result节点
 * @author Administrator
 *
 */
public class ResultConfig {
	/**
	 * 结果的标识
	 */
	private String name;
	
	/**
	 * 结果类型   redirect  forward  stream
	 */
	private String type;
	
	/**
	 * 结果的路径
	 */
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
