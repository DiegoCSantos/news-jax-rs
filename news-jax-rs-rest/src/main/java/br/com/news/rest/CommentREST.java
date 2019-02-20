package br.com.news.rest;

import java.util.List;

import br.com.news.domain.Comment;
import br.com.news.business.CommentService;

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

@Path("/comment")
public class CommentREST{

	
	private CommentService service;
	
	
	
 public CommentREST() {
		super();
		this.service = new CommentService();
	}

@POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response insert(Comment comment) {
	 
	 return Response.ok().entity(service.insert(comment)).build();
 }
	
 @PUT
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response update(Comment comment) {
	 
	 return Response.ok().entity(service.update(comment)).build();
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
	 
	 GenericEntity<List<Comment>> list = new GenericEntity<List<Comment>>(service.list()) {};
	 return Response.ok().entity(list).build();
 }
	


}
