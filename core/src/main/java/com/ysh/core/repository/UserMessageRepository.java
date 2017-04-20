package com.ysh.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ysh.core.model.UserMessage;

@Repository
public interface UserMessageRepository extends CrudRepository<UserMessage, String> {

}
