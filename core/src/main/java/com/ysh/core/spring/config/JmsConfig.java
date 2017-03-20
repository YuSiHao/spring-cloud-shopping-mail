package com.ysh.core.spring.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.destination.BeanFactoryDestinationResolver;
import org.springframework.jms.support.destination.DestinationResolver;

@Configuration
public class JmsConfig {

	@Bean
	public ConnectionFactory ConnectionFactory() {
		ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		return activeMQConnectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory myFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// topics should be possible. default is queue
		factory.setPubSubDomain(true);
		// set the embedded activMQ connectionFactory created by spring boot
		factory.setConnectionFactory(ConnectionFactory());

		factory.setMessageConverter(messageConverter());
		factory.setDestinationResolver(beanDestResolver());
		return factory;
	}

	@Bean
	public Destination topic() {
		return new ActiveMQTopic("testtopic");
	}

	@Bean
	public Destination queue() {
		return new ActiveMQQueue("testqueue");
	}

	// Resolve Destinations by Bean
	@Bean
	public DestinationResolver beanDestResolver() {
		return new BeanFactoryDestinationResolver();
	}

	// converts the object to json-format and vice versa
	@Bean
	public MessageConverter messageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_typeid");
		return converter;
	}

}
