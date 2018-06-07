package com.dearlg.game.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成对象
 * 
 * @author soft01
 * 
 */
@SuppressWarnings("unchecked")
public class ObjectFactory {
	/**
	 * key: userDao tradeDao tx...... value：就是对应的对象
	 * 
	 */
	private static Map<String, Object> objs = new HashMap<String, Object>();

	static {
		// 加载文件 object.txt
		// 读取文件
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src" + File.separator + "object.txt"))));
			String msg = reader.readLine();
			while (null != msg) {
				// userDao=com.njwangbo.banksystem.dao.impl.UserDaoImpl
				String[] msgs = msg.split("=");
				String key = msgs[0];
				String className = msgs[1];
				// value应该是className对应的那个对象
				Class objClass = Class.forName(className);
				// 通过class类型，反向生成对象 ----》java的反射
				Object obj = objClass.newInstance();
				objs.put(key, obj);
				msg = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * getBean:获得一个对象
	 * 
	 * @param beanName
	 *            配置文件中的key
	 * @return
	 */
	public static Object getBean(String beanName) {
		return objs.get(beanName);
	}
}
