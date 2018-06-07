package com.njwb.joybeans.util;

import java.io.IOException;
import java.util.Properties;

/**
 * properties文件解析工具
 * @author Administrator
 *
 */
public class PropertiesUtil {
	private static Properties prop = null;
	
	private static final String CONFIG_LOC = "joybeans/joybeans.properties";
	static{
		//加载CONFIG_LOC
		prop = new Properties();
		try {
			prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(CONFIG_LOC));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private PropertiesUtil(){
		
	}
	
	
	public static String getKey(String key){
		return prop.getProperty(key);
	}
}
