package br.com.news.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Error {
	
	private String message;
	private Integer code;
	private List<Map<String,String>> details;
	
	public Error(String message, Integer code, List<Map<String, String>> details) {
		super();
		this.message = message;
		this.code = code;
		this.details = details;
	}

	
	@SuppressWarnings("serial")
	public Error(String message, Integer code, Map<String, String> detail) {
		super();
		this.message = message;
		this.code = code;
		this.details = new ArrayList<Map<String, String>>(){{
			add(detail);
		}};
	}
	
	@SuppressWarnings("serial")
	public Error(String message, Integer code, String key, String value) {
		super();
		this.message = message;
		this.code = code;
		this.details = new ArrayList<Map<String, String>>(){{
			add(new HashMap<String, String>(){{
				put(key, value);
			}});
		}};
	}
	
	public Error() {
		super();
	}
	
	public Error(String message, Integer code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Map<String, String>> getDetails() {
		return details;
	}
	public void setDetails(List<Map<String, String>> details) {
		this.details = details;
	}
	 
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	@SuppressWarnings("serial")
	public Error add(String key, String value) {
		if(this.details==null)
			this.details=new ArrayList<>();
		
		this.details.add(new HashMap<String, String>(){{
			put(key, value);
		}});
		return this;
	}
	
	public Error add(Map<String, String> detail) {
		if(this.details==null)
			this.details=new ArrayList<>();
		
		this.details.add(detail);
		return this;
	}
	
	@SuppressWarnings("serial")
	public Error addErrorMessage(String message) {
		if(this.details==null)
			this.details=new ArrayList<>();
		
		this.details.add(new HashMap<String, String>(){{
			put("ErrorMessage", message);
		}});
		return this;
	}
	
	
	public Error addErrorBadRequest(String message) {
		this.addErrorMessage(message);
		
		this.code=400;
		this.message="BAD REQUEST";
		return this;
	}
	 
	public Error addErrorNotFound(String message) {
		this.addErrorMessage(message);
		
		this.code=404;
		this.message="NOT FOUND";
		return this;
	}
	 
	
	public boolean hasErrors() {
		if(this.details==null)
			return false;
		
		return !this.details.isEmpty();
	}

	
	public Error code(Integer code) {
		this.code=code;
		return this;
	}

}
