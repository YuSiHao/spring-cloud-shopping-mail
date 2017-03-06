package com.ysh.catalog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ysh.catalog.dao.CustomerDao;
import com.ysh.catalog.mapper.CustomerMapper;
import com.ysh.catalog.model.Customer;

import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> findAll() {
		return customerMapper.findAll();
	}

}
