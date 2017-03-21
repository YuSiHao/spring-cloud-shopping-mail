package com.ysh.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebInit {

	public static void main(String[] args) {
		System.out.println("start running auth service");
		SpringApplication.run(WebInit.class, args);
	}
}
