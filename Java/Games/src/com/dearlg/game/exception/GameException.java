package com.dearlg.game.exception;

public class GameException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String msg;

	
	
	public GameException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public GameException() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
