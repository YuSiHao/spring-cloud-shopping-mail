package com.ysh.core.dao;

import com.ysh.core.model.UserMessage;;

public interface UserMessageDao {

	public UserMessage findUserByName(String username);
}
