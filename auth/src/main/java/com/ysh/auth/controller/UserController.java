package com.ysh.auth.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping(value = "/currentUser", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		System.out.println("Username:" + UserController.getAuthenticatedUsername());
		return principal;
	}
	
	@RequestMapping(value = "/testClient", method = RequestMethod.GET)
	public String testClient() {
		System.out.println("testClient ok");
		return "testClient ok";
	}

	public static String getAuthenticatedUsername() {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

}
