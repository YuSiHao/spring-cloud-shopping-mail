package com.ysh.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value = "/testUrl", method = RequestMethod.GET)
	public String testClient() {
		System.out.println("testUrl ok");
		return "testUrl ok";
	}
}
