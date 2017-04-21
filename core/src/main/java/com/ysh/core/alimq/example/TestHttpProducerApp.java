package com.ysh.core.alimq.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ysh.core.alimq.example.producer.HttpMQProducer;


public class TestHttpProducerApp {

	/**
	 * 启动测试之前请修改配置文件:producer/producer.xml
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
		HttpMQProducer producer = context.getBean(HttpMQProducer.class);
		// 发送定时消息: producer.send("msg", "tag", "key", startDeliverTime);
		if (producer.send("msgsecond", "tag", "key")) {
			System.out.println("send message success");
		} else {
			System.out.println("send message failed");
		}
		context.close();
	}

}
