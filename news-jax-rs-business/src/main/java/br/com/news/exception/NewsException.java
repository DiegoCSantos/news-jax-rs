package br.com.news.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Diego
 *
 */
public class NewsException  extends RuntimeException {
	
	
     private Error error;
    
    
    public NewsException() {
		super();
		this.error= new Error();
	}
    
	public NewsException(Error error) {
		super();
		this.error = error;
	}




	public Error getError() {
		return error;
	}


	public void setError(Error error) {
		this.error = error;
	}


	public NewsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}


	public NewsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}


	public NewsException(String arg0) {
		super(arg0);
	}


	public NewsException(Throwable arg0) {
		super(arg0);
	}
    

	
	
	
}
