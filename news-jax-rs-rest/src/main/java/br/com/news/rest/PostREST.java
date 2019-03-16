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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.news.business.PostService;
import br.com.news.domain.Post;

@Path("/post")
public class PostREST {

	private PostService service;
	
	
	
 public PostREST() {
		super();
		this.service = new PostService();
	}

@POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response insert(Post post) {
	 
	 return Response.ok().entity(service.insert(post)).build();
 }
	
 @PUT
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response update(Post post) {
	 
	 return Response.ok().entity(service.update(post)).build();
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
	 
	 GenericEntity<List<Post>> list = new GenericEntity<List<Post>>(service.list()) {};
	 return Response.ok().entity(list).build();
 }
 
 @Path("/author/{idAuthor}")
 @GET
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response listByAuthor(@PathParam("idAuthor")Long idAuthor, @QueryParam("pageSize") int pageSize,
		 @QueryParam("pageNum") int pageNum) {
	 
	 GenericEntity<List<Post>> list = new GenericEntity<List<Post>>(service.listByAuthor(idAuthor, pageSize, pageNum)) {};
	 return Response.ok().entity(list).build();
 }
 
 
 @Path("/category/{idCategory}")
 @GET
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public Response listByCategory(@PathParam("idCategory")Long idCategory, @QueryParam("pageSize") int pageSize,
		 @QueryParam("pageNum") int pageNum) {
	 
	 GenericEntity<List<Post>> list = new GenericEntity<List<Post>>(service.listByCategory(idCategory, pageSize, pageNum)) {};
	 return Response.ok().entity(list).build();
 }
 
 
}
