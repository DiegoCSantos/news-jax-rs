package br.com.news.exec;


import java.io.File;

import org.apache.catalina.startup.Tomcat;


public class Main {

	
	public static void main(String[] args) {
		
		try {
			
			String war="\\news-api.war";
			String contextPath = "/news-api";
	        String appBase = ".";
	        Tomcat tomcat = new Tomcat();     
	        tomcat.setPort(8080);
	        tomcat.getHost().setAppBase(appBase);
	        tomcat.addWebapp(contextPath,war);
	        
			tomcat.start();
			tomcat.getServer().await();
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
}
