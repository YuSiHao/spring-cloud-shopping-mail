package com.ysh.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysh.core.dao.LogMessageDao;
import com.ysh.core.model.LogMessage;

@Service
public class LogService {

	@Autowired
	private LogMessageDao logMessageDao;

	public void saveLogMessage(String logMessage, String logId) {
		LogMessage log = new LogMessage();
		log.setLogId(logId);
		log.setMesssage(logMessage);
		logMessageDao.save(log);
		System.out.println("save logId:" + logId + "is success");
	}
	
	public LogMessage findLogById(String logId){
		LogMessage logMessage = logMessageDao.findLogByLogId(logId);
		System.out.println("logMessage is " + logMessage);
		return logMessage;
	}

}
