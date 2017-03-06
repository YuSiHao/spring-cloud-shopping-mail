package com.ysh.catalog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ysh.catalog.model.Customer;


public interface CustomerMapper {
	
final String FIND_ALL_CUSTOMERS = "SELECT * FROM customer";
	
	@Select(FIND_ALL_CUSTOMERS)   
	List<Customer> findAll();
	
}
