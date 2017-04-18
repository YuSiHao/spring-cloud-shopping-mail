package com.ysh.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payform", schema = "order")
public class Payform implements Serializable {

	private static final long serialVersionUID = 1094146326556193345L;

	@Id
	@Column(name = "orderid")
	private String orderId;

	@Column(name = "name")
	private String name;

	@Column(name = "no")
	private String no;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

}
