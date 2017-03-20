package com.ysh.core.spring.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

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
	public DefaultJmsListenerContainerFactory myFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// topics should be possible. default is queue
		factory.setPubSubDomain(true);
		// set the embedded activMQ connectionFactory created by spring boot
		factory.setConnectionFactory(connectionFactory);

		factory.setMessageConverter(messageConverter());
		factory.setDestinationResolver(beanDestResolver());
		return factory;
	}

	@Bean
	public Destination topic() {
		return new ActiveMQTopic("topic");
	}

	@Bean
	public Destination queue() {
		return new ActiveMQQueue("queue");
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
