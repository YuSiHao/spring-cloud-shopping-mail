package com.ysh.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ysh.core.model.LogMessage;

@Repository
public interface LogMessageRepository extends CrudRepository<LogMessage, String> {

}
