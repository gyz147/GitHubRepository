package com.dearlg.game.util;
/**
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 * 
	 * @param str
	 * @return 如果字符串为null或者空串 返回true,否则返回false
	 */
	public static boolean isEmpty(String str){
		if(null == str || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
}
