package com.ysh.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.catalog.dao.CustomerDao;
import com.ysh.catalog.model.Customer;
import com.ysh.catalog.service.CustomerService;

@RestController
@RequestMapping(value = "/forCustomer")
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/byDb", method = RequestMethod.GET)
	public List<Customer> findAllCustomersByDb() {
		List<Customer> CustomerList = customerDao.findAll();
		return CustomerList;
	}
	
	@RequestMapping(value = "/byApiCall", method = RequestMethod.GET)
	public List<Customer> findAllCustomersByApiCall() {
		List<Customer> CustomerList = customerService.findAll();
		return CustomerList;
	}
	
	

}
