package com.ysh.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ysh.core.dao.LogMessageDao;
import com.ysh.core.model.LogMessage;
import com.ysh.core.repository.LogMessageRepository;

@Component
public class LogMessageDaoImpl implements LogMessageDao {

	@Autowired
	private LogMessageRepository logMessageRepository;

	@Override
	public LogMessage findLogByLogId(String logId) {
		return logMessageRepository.findOne(logId);
	}

	@Override
	public void save(LogMessage logMessage) {
		// TODO Auto-generated method stub
		LogMessage logMessage2= logMessageRepository.save(logMessage);
		System.out.println(logMessage2);
	}

}
