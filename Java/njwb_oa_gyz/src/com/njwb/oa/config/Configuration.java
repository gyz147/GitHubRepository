package com.njwb.oa.config;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * mvc配置管理类
 * @author Administrator
 *
 */
public class Configuration {
	private static Document document;
	
	static{
		SAXReader reader = new SAXReader();
		try {
			document = reader.read(Configuration.class.getClassLoader().getResourceAsStream("mvc.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ActionMappingConfig parse(){
		ActionMappingConfig actionMappingConfig = new ActionMappingConfig();
		
		List<Element> actionElementList = document.selectNodes("/actions/action");
		Iterator<Element> actionElementIt = actionElementList.iterator();
		while(actionElementIt.hasNext()){
			Element actionElement = actionElementIt.next();
			//创建一个ActionConfig对象 ---->代表action节点
			ActionConfig actionConfig = new ActionConfig();
			//给actionCofing对象设置属性值-------》来自于标签中的属性值
			actionConfig.setName(actionElement.attributeValue("name"));
			actionConfig.setClassName(actionElement.attributeValue("class"));
			actionConfig.setMethodName(actionElement.attributeValue("method"));
			
			actionMappingConfig.getActionConfigMap().put(actionElement.attributeValue("name"), actionConfig);
			
			//解析result节点
			List<Element> resultElementList = actionElement.selectNodes("result");
			
			Iterator<Element> resultElementIt = resultElementList.iterator();
			
			while(resultElementIt.hasNext()){
				Element resultElement = resultElementIt.next();
				ResultConfig resultConfig = new ResultConfig();
				resultConfig.setName(resultElement.attributeValue("name"));
				resultConfig.setPath(resultElement.getTextTrim());
				resultConfig.setType(resultElement.attributeValue("type"));
				actionConfig.getResultsMap().put(resultElement.attributeValue("name"), resultConfig);
			}
			
		}
	
		
		return actionMappingConfig;
	}
	
	
	public static void main(String[] args) {
		Configuration config = new Configuration();
		ActionMappingConfig actionMappingConfig = config.parse();
		//给一个action的name为login
		ActionConfig actionConfig =  actionMappingConfig.getActionConfigMap().get("/login");
		
		//System.out.println(actionConfig.getName() + "--" + actionConfig.getClassName());
		
		ResultConfig resultConfig = actionConfig.getResultsMap().get("error");
		System.out.println(resultConfig.getType() + "---" + resultConfig.getPath());
	}

}
