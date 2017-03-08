package com.ysh.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;

@RefreshScope
@EnableConfigurationProperties
@SpringBootApplication
@EnableDiscoveryClient
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
