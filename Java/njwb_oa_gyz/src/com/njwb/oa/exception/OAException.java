package com.njwb.oa.exception;

/**
 * oa系统的自定义异常
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class OAException extends Exception {
	public OAException(String msg) {
		super(msg);
	}
}
