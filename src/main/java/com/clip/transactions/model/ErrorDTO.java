package com.clip.transactions.model;

import java.io.Serializable;

public class ErrorDTO implements Serializable{

	
	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "{\"code\":"+code+",\"message\":"+message+"}";
	}
	
	public ErrorDTO(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ErrorDTO() {
		}

	private static final long serialVersionUID = 1L;

}
