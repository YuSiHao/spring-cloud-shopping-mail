package com.ysh.catalog.dao;

import java.util.List;

import com.ysh.catalog.model.Customer;


public interface CustomerDao {
	
	List<Customer> findAll();
	
	Customer findByName(String name);
}
