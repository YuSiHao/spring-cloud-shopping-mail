package com.ysh.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@EnableConfigurationProperties
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class WebInit {

	@Autowired
	void setEnviroment(Environment env) {
		System.out.println("application name from env: " + env.getProperty("application.name"));
		System.out.println("location from env: " + env.getProperty("application.location"));
	}
	
	public static void main(String[] args) {
		System.out.println("start running catalog service");
		SpringApplication.run(WebInit.class, args);
	}
}
