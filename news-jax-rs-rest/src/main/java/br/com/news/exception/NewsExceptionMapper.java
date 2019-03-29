package br.com.news.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NewsExceptionMapper implements ExceptionMapper<NewsException>{
	

	@Override
	public Response toResponse(NewsException exception) {
		Integer errorCode =exception.getError().getCode();
		
		return Response.status(errorCode==null?500:errorCode).entity(exception.getError()).build();
	}

}
