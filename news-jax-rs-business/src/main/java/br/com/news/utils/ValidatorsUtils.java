package br.com.news.utils;

import java.util.List;
import java.util.Map;


public class ValidatorsUtils {
	
	public void validateRequired(Object o, String menssagem) {
		if(isNullOrEmpty(o)) {}
	}
	
	
	@SuppressWarnings("rawtypes")
	public boolean isNullOrEmpty(Object o) {
		if(o==null)
			return true;
		
		if(o instanceof String) {
			return ((String) o).isEmpty();
		}
		if(o instanceof List) {
			return ((List) o).isEmpty();
		}
		
		if(o instanceof Map<?, ?>) {
			return ((Map) o).isEmpty();
		}
		return false;
	}

}
