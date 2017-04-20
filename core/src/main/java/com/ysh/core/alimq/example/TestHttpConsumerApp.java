package com.ysh.core.alimq.example;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ysh.core.alimq.example.consumer.HttpMQConsumer;
import com.ysh.core.model.SimpleMessage;


public class TestHttpConsumerApp {

	/**
	 * 启动测试之前请修改配置文件:consumer/consumer.xml
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		HttpMQConsumer consumer = context.getBean(HttpMQConsumer.class);
		List<SimpleMessage> list = consumer.pull();
		if (list != null && list.size() > 0) {
			for (SimpleMessage simpleMessage : list) {
				System.out.println(simpleMessage);

				// 当消息处理成功后，需要进行delete，如果不及时delete将会导致重复消费此消息
				String msgHandle = simpleMessage.getMsgHandle();
				if (consumer.delete(msgHandle)) {
					System.out.println("delete success: " + msgHandle);
				} else {
					System.out.println("delete failed: " + msgHandle);
				}
			}
		}
		context.close();
	}

}
