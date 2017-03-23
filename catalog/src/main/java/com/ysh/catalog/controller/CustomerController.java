package com.ysh.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

	@RequestMapping(value = "/byDb", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<Customer> findAllCustomersByDb() {
		List<Customer> CustomerList = customerDao.findAll();
		return CustomerList;
	}

	@RequestMapping(value = "/byApiCall", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<Customer> findAllCustomersByApiCall() {
		List<Customer> CustomerList = customerService.findAll();
		return CustomerList;
	}
	
	@HystrixCommand(fallbackMethod = "fallBackFindByName")
	@RequestMapping(value = "/byCustomerName", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Customer findCustomersByName(String name) throws Exception{
		Customer customer = customerDao.findByName(name);
		if(customer==null){
			throw new Exception();
		}
		return customer;
	}
	
	public Customer fallBackFindByName(String name){
		Customer customer = new Customer();
		customer.setAge(11);
		customer.setName("Tom");
		customer.setId(123);
		return customer;
	}

}
