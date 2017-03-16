package com.ysh.catalog.api.controller;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.catalog.api.model.Customer;

@FeignClient(name = "catalog", url = "http://localhost:9966", configuration = FeignClientsConfiguration.class)
@RestController
@RequestMapping(value = "/forCustomer")
public interface CustomerController {

	@RequestMapping(value = "/byDb", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<Customer> findAllCustomersByDb();

	@RequestMapping(value = "/byApiCall", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<Customer> findAllCustomersByApiCall();
}
