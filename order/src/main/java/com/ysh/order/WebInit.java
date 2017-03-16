package com.ysh.order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.ysh.catalog.api.controller.CustomerController;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = CustomerController.class)
public class WebInit {
	
	private static Logger logger = LoggerFactory.getLogger(WebInit.class);
	
	public static void main(String[] args) {
		System.out.println("start running order service");
		logger.debug("start logging");
		SpringApplication.run(WebInit.class, args);
	}
}