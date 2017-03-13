package com.ysh.order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebInit {
	
	private static Logger logger = LoggerFactory.getLogger(WebInit.class);
	
	public static void main(String[] args) {
		System.out.println("start running order service");
		logger.debug("start logging");
		SpringApplication.run(WebInit.class, args);
	}
}