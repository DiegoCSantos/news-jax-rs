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

import br.com.news.business.CategoryService;
import br.com.news.domain.Category;

@Path("/category")
public class CategoryREST{


	private CategoryService service;
	
	
	
	public CategoryREST() {
		super();
		this.service= new CategoryService();
	}

@POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response insert(Category category) {
	 
	 return Response.ok().entity(service.insert(category)).build();
 }
	
 @PUT
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response update(Category category) {
	 
	 return Response.ok().entity(service.update(category)).build();
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
	 
	 GenericEntity<List<Category>> list = new GenericEntity<List<Category>>(service.list()) {};
	 return Response.ok().entity(list).build();
 }


}
