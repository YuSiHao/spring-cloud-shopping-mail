package com.ysh.core.alimq.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ysh.core.alimq.example.consumer.HttpMQConsumer;

public class TestHttpDeleteApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		HttpMQConsumer consumer = context.getBean(HttpMQConsumer.class);
		boolean IsDeleteSuccessful = consumer.delete(
				"X1BFTkRJTkdNU0dfI2NoYW5kbGVyI3FkMmludGVybmV0LTAyIzEjMSNDSURfMTAzMTAzMzBfQF9AXzcwN0M4Q0M0MTIyQzRDODQxMTczNjZBNTVEOEU5REUxX0BfQF9sNGM=");
		System.out.println("IsDeleteSuccessful:" + IsDeleteSuccessful);
	}
}
