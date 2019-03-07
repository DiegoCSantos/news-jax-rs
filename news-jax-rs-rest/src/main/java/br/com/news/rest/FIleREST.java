package br.com.news.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import br.com.news.business.FileService;
import br.com.news.domain.File;

@Path("/file")
public class FIleREST {
	
	FileService service;

	public FIleREST(FileService service) {
		super();
		this.service = service;
	}

	public FIleREST() {
		super();
		this.service= new FileService();
	}
	
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(
	        @DefaultValue("true") @FormDataParam("enabled") boolean enabled,
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail) {
		
		File file = new File();
		file.setName(fileDetail.getFileName());
		file.setType(fileDetail.getType());
		
		try {
			byte[] bytes =IOUtils.toByteArray(uploadedInputStream);
			
			file.setContent(Base64.getEncoder().encodeToString(bytes));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		file = service.insert(file);
		file.setContent("");
		return Response.ok().entity(file).build();
	}
	
	
	@Path("/{id}")
	@GET
	public Response downloadFile(@PathParam("id") Long id) {
		
		File file= service.select(id);
		
		return Response.ok(Base64.getDecoder().decode(file.getContent()))
				.header("Content-Disposition", "attachment; filename="+file.getName()+"")
				.build();
		
	}
	
	@Path("/{id}")
	@DELETE
	public Response delete(@PathParam("id") Long id) {
		
		service.delete(id);
		
		return Response.ok().build();
		
	}
	

}
