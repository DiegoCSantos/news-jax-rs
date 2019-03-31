package br.com.news.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import br.com.news.exception.Error;;

@Provider
public class NewsRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String autorizayion=requestContext.getHeaderString("Autorization");
		
		//Validate token ...
		if(!requestContext.getMethod().equalsIgnoreCase("GET")) {
			if(autorizayion == null || autorizayion.isEmpty()) {
				requestContext.abortWith(
						Response.status(401).entity(
								new Error().addErrorNotAuthorized("Header Autorization not found").code(401)).build());
			}
		}
	}

}
