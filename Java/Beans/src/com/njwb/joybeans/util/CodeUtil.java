package com.njwb.joybeans.util;

import java.util.Random;

import oracle.net.aso.MD5;

public class CodeUtil {
	public static String getCode() {
		Random random = new Random();
		String code = "";
		for (int i = 0; i < 4; i++) {
			code = code + random.nextInt(10);
		}
		return code;
	}

	public static String getSuffix(String str) {
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '.') {
				index = i;
			}
		}
		return str.substring(index, str.length());
	}

	public static String aaa() {
		// MD5.class.
		return "";
	}
}
