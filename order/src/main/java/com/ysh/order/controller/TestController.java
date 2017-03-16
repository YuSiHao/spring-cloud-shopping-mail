package com.ysh.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.catalog.api.controller.CustomerController;
import com.ysh.catalog.api.model.Customer;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CustomerController customerController;
	
	// @Autowired
	// private UserControllerClient userControllerClient;
	
	//@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String testAuth() {
		String result = "fail";
		// result = userControllerClient.testClient();
		return result;
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<Customer> testCustomer() {
		List<Customer> customers = customerController.findAllCustomersByDb();
		return customers;
	}

}
