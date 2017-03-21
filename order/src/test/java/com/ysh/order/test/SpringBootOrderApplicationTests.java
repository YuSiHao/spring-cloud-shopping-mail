package com.ysh.order.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class SpringBootOrderApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("ok");
	}

}