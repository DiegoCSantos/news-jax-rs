package br.com.news.rest;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.v3.jaxrs2.SwaggerSerializers;


@ApplicationPath("/")
public class NewsApplication  extends ResourceConfig {

	public NewsApplication() {
		super();
		
		this.register(ApiListingResource.class);
	    this.register(SwaggerSerializers.class);
	    BeanConfig config = new BeanConfig();
	    config.setConfigId("spring-boot-jaxrs-swagger");
	    config.setTitle("Spring boot jaxrs swagger integration");
	    config.setVersion("v1");
	    config.setBasePath("news-api");
	    config.setPrettyPrint(true);
	    config.setScan(true);
		super.packages("br.com.news.rest", "io.swagger.v3.jaxrs2.integration.resources");
	
	}

	
	
	

}
