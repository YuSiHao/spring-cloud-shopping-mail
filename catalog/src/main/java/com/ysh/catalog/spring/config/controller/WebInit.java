package com.ysh.catalog.spring.config.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebInit {

	public static void main(String[] args) {
		System.out.println("start running catalog service");
		SpringApplication.run(WebInit.class, args);
	}
}
