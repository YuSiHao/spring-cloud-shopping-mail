package com.ysh.core.dao;

import com.ysh.core.model.LogMessage;;

public interface LogMessageDao {

	public LogMessage findLogByLogId(String logId);

	public void save(LogMessage logMessage);
}
