package com.ysh.catalog.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/forDiscovery")
public class DiscoveryController {
	
	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient; // just here for testing

	@RequestMapping(value = "/do", method = RequestMethod.GET)
	public String doDiscoveryService() {
		StringBuilder buf = new StringBuilder();
		List<String> serviceIds = discoveryClient.getServices();
		if (!CollectionUtils.isEmpty(serviceIds)) {
			for (String s : serviceIds) {
				System.out.println("serviceId:" + s);
				List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
				if (!CollectionUtils.isEmpty(serviceInstances)) {
					for (ServiceInstance si : serviceInstances) {
						buf.append("[" + si.getServiceId() + " host=" + si.getHost() + " port=" + si.getPort() + " uri="
								+ si.getUri() + "]");
					}
				} else {
					buf.append("no service.");
				}
			}
		}
		return buf.toString();
	}
	
}
