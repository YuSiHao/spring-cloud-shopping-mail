package com.ysh.catalog.spring.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.catalog.dao.CustomerDao;
import com.ysh.catalog.model.Customer;

@RestController
@RequestMapping(value = "/forCustomer")
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public List<Customer> readUserInfo() {
		List<Customer> CustomerList = customerDao.findAll();
		return CustomerList;
	}

}
