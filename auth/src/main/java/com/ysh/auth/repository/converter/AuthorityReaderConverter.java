package com.ysh.auth.repository.converter;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysh.auth.model.Authority;

@Component
public class AuthorityReaderConverter implements Converter<String, Authority> {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public Authority convert(String authority) {
		Authority auth = null;
		try {
			auth = objectMapper.readValue(authority, Authority.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return auth;
	}
}
