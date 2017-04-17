package com.ysh.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysh.order.model.Order;

public interface IOrderCurd extends JpaRepository<Order, String>{

}
