package com.ysh.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysh.order.model.Payform;


public interface IOrderCurd extends JpaRepository<Payform, String>{

}
