package com.ysh.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class WebInit {

	public static void main(String[] args) {
		System.out.println("start running auth service");
		SpringApplication.run(WebInit.class, args);
	}
}
