package com.ysh.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "auth", url = "http://localhost:8090", configuration = FeignClientsConfiguration.class)
@RestController
public interface UserControllerClient {

	@RequestMapping(value = "/testClient", method = RequestMethod.GET)
	public String testClient();

}
