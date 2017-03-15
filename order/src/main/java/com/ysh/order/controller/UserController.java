package com.ysh.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	// @Autowired
	// private UserControllerClient userControllerClient;

	@RequestMapping(value = "/testAuth", method = RequestMethod.GET)
	public String testAuth() {
		String result = "fail";
		// result = userControllerClient.testClient();
		return result;
	}

}
