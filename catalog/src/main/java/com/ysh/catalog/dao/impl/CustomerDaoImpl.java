package com.ysh.catalog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysh.catalog.dao.CustomerDao;
import com.ysh.catalog.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerDao userMapper;

	public List<Customer> findAll() {
		List<Customer> customers = userMapper.findAll();
		return customers;
	}

	@Override
	public Customer findByName(String name){
		Customer customer = userMapper.findByName(name);
		return customer;
	}
	
	
	
	
}
