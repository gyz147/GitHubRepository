package com.njwb.joybeans.util;

import java.util.UUID;

/**
 * uuid生成器
 * @author Administrator
 *
 */
public class UUIDGenerator {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "").substring(0,8);
	}
}
