package com.ysh.core.listener.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ysh.core.model.JmsMessage;


//@Component
public class QueueListener {

	
	@JmsListener(destination = "testqueue", containerFactory = "jmsFactory")
	public void method1(JmsMessage jmsMessage) {
		System.out.println("Method1: " + jmsMessage.toString());
	}

	@JmsListener(destination = "testqueue", containerFactory = "jmsFactory")
	public void method2(JmsMessage jmsMessage) {
		System.out.println("Method2: " + jmsMessage.toString());
	}

	@JmsListener(destination = "testqueue", containerFactory = "jmsFactory")
	public void method3(JmsMessage jmsMessage) {
		System.out.println("Method3: " + jmsMessage.toString());
	}
}
