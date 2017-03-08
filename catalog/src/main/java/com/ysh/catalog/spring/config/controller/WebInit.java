package com.ysh.catalog.spring.config.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WebInit {

	@Autowired
	void setEnviroment(Environment env) {
	    System.out.println("mysqldb.datasource.username from env: " 
	        + env.getProperty("mysqldb.datasource.username"));
	}
	
	public static void main(String[] args) {
		System.out.println("start running catalog service");
		SpringApplication.run(WebInit.class, args);
	}
}
