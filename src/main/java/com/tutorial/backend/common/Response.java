package com.tutorial.backend.common;

import java.util.HashMap;
import java.util.Map;

import com.tutorial.backend.util.CommonConstants;

public class Response {

	private int code;
	private String status = CommonConstants.SUCCESS_MSG;
	private String message;
	private Map<String, Object> data = new HashMap<>();
	
	public Response() {
		//Empty Constructor
	}
	
	public Response(int code, String status, Map<String, Object> data) {
		this.code = code;
		this.status = status;
		this.data = data;
	}
	
	public Response(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	public Response(int code, String status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}
	
	public Response(int code, String status, String message, Map<String, Object> data) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
