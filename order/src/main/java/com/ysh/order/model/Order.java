package com.ysh.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order", schema = "order")
public class Order {
	
	@Id
	@Column(name = "OrderId")
	private String OrderId;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "No")
	private String No;
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
}
