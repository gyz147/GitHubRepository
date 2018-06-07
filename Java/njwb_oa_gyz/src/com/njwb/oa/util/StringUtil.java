package com.njwb.oa.util;
/**
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtil {
	/**
	 *   
	 * @param msgxxx
	 * @return  xxxxxx
	 */
	public static boolean isEmpty(String msg){
		if(null == msg ||"".equals(msg.trim())){
			return true;
			
		}else{
			return false;
			
		}
		
	}
	
}
