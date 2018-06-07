package com.njwb.oa.factory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 对象工厂
 * 
 * @author Administrator
 * 
 */
public class ApplicationContext {
	private static Map<String, Object> objMap = new HashMap<String, Object>();

	static {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(ApplicationContext.class.getClassLoader().getResourceAsStream("bean.xml"));
			parse(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析
	 * 
	 * @param document
	 */
	@SuppressWarnings("unchecked")
	private static void parse(Document document) throws Exception {
		List<Element> beanElementList = document.selectNodes("/beans/bean");
		Iterator<Element> beanElementIt = beanElementList.iterator();
		while (beanElementIt.hasNext()) {
			Element beanElement = beanElementIt.next();
			String beanId = beanElement.attributeValue("id");
			String className = beanElement.attributeValue("class");
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			objMap.put(beanId, obj);
			List<Element> properyList = beanElement.selectNodes("./property");
			Iterator<Element> properyIt = properyList.iterator();
			while (properyIt.hasNext()) {
				Element properyElement = properyIt.next();
				String propName = properyElement.attributeValue("name");// userDao
				String propRef = properyElement.attributeValue("ref");// 引用的是其他bean的id值
				String methodName = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
				Method method = clazz.getDeclaredMethod(methodName, objMap.get(propRef).getClass().getInterfaces());
				method.invoke(obj, objMap.get(propRef));
			}
		}
	}

	public static Object getBean(String id) {
		return objMap.get(id);
	}
}
