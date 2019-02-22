package br.com.news.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.news.business.AuthorService;
import br.com.news.domain.Author;

@Path("/author")
public class AuthorREST{
	

	private AuthorService service;
	
	
	
 public AuthorREST() {
		super();
		this.service = new AuthorService();
 }

@POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response insert(Author author) {
	 
	 return Response.ok().entity(service.insert(author)).build();
 }
	
 @PUT
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response update(Author author) {
	 
		return Response.ok().entity(service.update(author)).build();
 }

 @Path("/{id}")
 @DELETE
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response delete(@PathParam("id") Long id) {
	 
	 service.delete(id);
	 return Response.ok().build();
 }
 
 
 @Path("/{id}")
 @GET
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response select(@PathParam("id") Long id) {
	 
	 
	 return Response.ok().entity(service.select(id)).build();
 }
 
 
 
 @GET
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response list() {
	 
	 GenericEntity<List<Author>> list = new GenericEntity<List<Author>>(service.list()) {};
	 return Response.ok().entity(list).build();
 }



}
