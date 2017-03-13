package com.ysh.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ysh.auth.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
