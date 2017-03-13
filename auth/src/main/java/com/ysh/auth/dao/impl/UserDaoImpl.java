package com.ysh.auth.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ysh.auth.dao.UserDao;
import com.ysh.auth.model.User;
import com.ysh.auth.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByName(String username) {
		return userRepository.findOne(username);
	}

}
