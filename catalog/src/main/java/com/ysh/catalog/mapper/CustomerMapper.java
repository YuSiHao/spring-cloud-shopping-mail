package com.ysh.catalog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.ysh.catalog.model.Customer;

@Mapper
public interface CustomerMapper {

	final String FIND_ALL_CUSTOMERS = "SELECT * FROM customer";

	@Select(FIND_ALL_CUSTOMERS)
	@Result(id = true, property = "id", column = "id", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	List<Customer> findAll();

}
