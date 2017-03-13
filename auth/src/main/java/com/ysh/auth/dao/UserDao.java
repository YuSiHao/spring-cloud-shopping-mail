package com.ysh.auth.dao;

import com.ysh.auth.model.User;

public interface UserDao {

	public User findUserByName(String username);
}
