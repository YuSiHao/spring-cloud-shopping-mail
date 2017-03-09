package com.ysh.catalog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ysh.catalog.model.Customer;
import com.ysh.catalog.service.CustomerService;
import com.ysh.catalog.utils.Constants;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	protected RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "fallBackFindAll")
	public List<Customer> findAll() {
		return restTemplate.getForObject("http://" + Constants.LOCALHOST + "/forCustomer/byDb", List.class);
	}

	@SuppressWarnings("unused")
	private List<Customer> fallBackFindAll() {
		System.out.println("HystrixCommand fallbackMethod handle!");
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setId(001);
		customer.setAge(18);
		customer.setName("chandler");
		customerList.add(customer);
		return customerList;

	}
	
	

}
