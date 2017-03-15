package com.ysh.auth.repository.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysh.auth.model.Authority;

@Component
public class AuthorityWriterConverter implements Converter<Authority, String> {

	@Autowired
	private ObjectMapper objectMapper;
	

	@Override
	public String convert(Authority authority) {
		String auth = null;
		try {
			auth = objectMapper.writeValueAsString(authority);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auth;
	}
}
