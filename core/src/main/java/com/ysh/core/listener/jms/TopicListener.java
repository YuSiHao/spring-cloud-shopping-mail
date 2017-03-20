package com.ysh.core.listener.jms;



import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ysh.core.model.JmsMessage;


@Component
public class TopicListener {

	
	@JmsListener(destination = "testtopic", containerFactory = "jmsFactory")
	public void method1(JmsMessage jmsMessage) {
		System.out.println("Method1: " + jmsMessage.toString());
	}

	@JmsListener(destination = "testtopic", containerFactory = "jmsFactory")
	public void method2(JmsMessage jmsMessage) {
		System.out.println("Method2: " + jmsMessage.toString());
	}
	
	@JmsListener(destination = "testtopic", containerFactory = "jmsFactory")
	public void method3(JmsMessage jmsMessage) {
		System.out.println("Method3: " + jmsMessage.toString());
	}
	
	@JmsListener(destination = "testtopic1", containerFactory = "jmsFactory")
	public void method4(final Message message) throws Exception{
		System.out.println(message.getJMSDestination().toString());
	}
	
	
}
