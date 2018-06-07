package com.njwb.oa.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 代表actions节点
 * @author Administrator
 *
 */
public class ActionMappingConfig {
	/**
	 * key是action节点的name值
	 */
	private Map<String, ActionConfig> actionConfigMap = new HashMap<String, ActionConfig>();

	public Map<String, ActionConfig> getActionConfigMap() {
		return actionConfigMap;
	}

	public void setActionConfigMap(Map<String, ActionConfig> actionConfigMap) {
		this.actionConfigMap = actionConfigMap;
	}
	
	
}
