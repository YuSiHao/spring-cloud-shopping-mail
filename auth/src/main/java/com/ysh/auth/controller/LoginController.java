package com.ysh.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Request;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/myLogin", method = RequestMethod.GET)
	public ModelAndView toLoginInPage() {
		System.out.println("toLoginInPage");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/mySessionLogin", method = RequestMethod.GET)
	public String userLogin(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request) {
		System.out.println("username is " + username + "password is " + password);
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = authenticationManager.authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		HttpSession session = request.getSession();
		session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // set
		return "login ok";
	}

	@RequestMapping(value = "/getCode", method = RequestMethod.GET)
	public String getCode(@RequestParam(value = "code") String code) {
		System.out.println("code is " + code);
		return "getcode";
	}
	
	@RequestMapping(value = "/getAccessToken", method = RequestMethod.GET)
	public String getAccessToken(HttpServletRequest request) {
		return "getaccesstoken";
	}

}
