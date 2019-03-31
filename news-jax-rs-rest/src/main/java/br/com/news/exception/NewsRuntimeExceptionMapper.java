package br.com.news.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NewsRuntimeExceptionMapper  implements ExceptionMapper<RuntimeException>{

	@Override
	public Response toResponse(RuntimeException exception) {
		Error error = new Error();
		error.setCode(500);
		error.setMessage("Internal Server Error");
		
		error.addErrorMessage(exception.getMessage());
		error.add("LocalizedMessage",exception.getLocalizedMessage());
		
		if(exception.getCause() != null) {
			error.add("Throwable Message",exception.getCause().getLocalizedMessage());
			error.add("Throwable LocalizedMessage",exception.getCause().getLocalizedMessage());
		}
		return Response.status(500).entity(error).build();
	}

}
