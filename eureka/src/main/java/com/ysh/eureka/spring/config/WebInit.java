package com.ysh.eureka.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WebInit {
	
	public static void main(String[] args) {
		System.out.println("start running eureka service");
		SpringApplication.run(WebInit.class, args);
	}
}
