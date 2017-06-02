package com.ysh.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.catalog.api.controller.CustomerController;
import com.ysh.catalog.api.model.Customer;
import com.ysh.order.dao.IOrderCurd;
import com.ysh.order.model.Payform;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CustomerController customerController;

	@Autowired
	private IOrderCurd iOrderCurd;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	// @Autowired
	// private UserControllerClient userControllerClient;

	// @PreAuthorize("#oauth2.hasScope('server')")
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

	@RequestMapping(value = "/order", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<Payform> findOrders() {
		try {
			setOrder();
		} catch (Exception e) {
			System.out.println("发生回滚");
		}
		List<Payform> orders = iOrderCurd.findAll();
		System.out.println("findOrders");
		redisTemplate.opsForValue().set("jack", "123");
		System.out.println("jack no is:" + redisTemplate.opsForValue().get("jack"));
		return orders;
	}

	@Transactional
	public void setOrder() {
		Payform payform = new Payform();
		payform.setName("testTran");
		iOrderCurd.save(payform);
		throw new RuntimeException();
	}

	@RequestMapping(value = "/testAop", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String testAop(@RequestParam(defaultValue = "") String name) {
		testAopParam(name);
		return "success";
	}

	public String testAopParam(String name) {
		return "ok";
	}

}
