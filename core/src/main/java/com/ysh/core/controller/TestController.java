package com.ysh.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysh.core.model.LogMessage;
import com.ysh.core.service.LogService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping(value = "/testUrl", method = RequestMethod.GET)
	public String testClient() {
		System.out.println("testUrl ok");
		return "testUrl ok";
	}
	
	@RequestMapping(value = "/testMongDb", method = RequestMethod.GET)
	public String testMongoDb() {
		String logMessage = "hello";
		String logId = "123123dsfsf";
		logService.saveLogMessage(logMessage, logId);
		return "save ok";
	}
	
	@RequestMapping(value = "/findLogbyId", method = RequestMethod.GET)
	public String findLogMessagebyId() {
		String logId = "12313123";
		LogMessage logMessage = logService.findLogById(logId);
		return logMessage.getMesssage();
	}
	
	
}
