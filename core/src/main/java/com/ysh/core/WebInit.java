package com.ysh.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.ysh.core.model.JmsMessage;

@SpringBootApplication
@EnableJms
public class WebInit implements CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		System.out.println("start running core service");
		SpringApplication.run(WebInit.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		System.out.println("sending three topic messages, 9 listener should receive the messages");
		jmsTemplate.convertAndSend("topic", new JmsMessage("info", "topic message1"));
		jmsTemplate.convertAndSend("topic", new JmsMessage("info", "topic message2"));
		jmsTemplate.convertAndSend("topic", new JmsMessage("info", "topic message3"));

		System.out.println("sending 4 queue messages, 4 (different) listener should receive the messages");
		jmsTemplate.convertAndSend("queue", new JmsMessage("info", "queue message"));
		jmsTemplate.convertAndSend("queue", new JmsMessage("info", "queue message"));
		jmsTemplate.convertAndSend("queue", new JmsMessage("info", "queue message"));
		jmsTemplate.convertAndSend("queue", new JmsMessage("info", "queue message"));
	}

}
