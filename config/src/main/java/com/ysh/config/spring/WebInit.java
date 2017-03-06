package com.ysh.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class WebInit {

	public static void main(String[] args) {
		System.out.println("start running config service");
		SpringApplication.run(WebInit.class, args);
	}
}
