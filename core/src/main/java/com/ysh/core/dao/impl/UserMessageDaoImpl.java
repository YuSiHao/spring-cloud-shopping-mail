package com.ysh.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ysh.core.dao.UserMessageDao;
import com.ysh.core.model.UserMessage;
import com.ysh.core.repository.UserMessageRepository;

@Component
public class UserMessageDaoImpl implements UserMessageDao {

	@Autowired
	private UserMessageRepository userMessageRepository;

	@Override
	public UserMessage findUserByName(String username) {
		return userMessageRepository.findOne(username);
	}

}
