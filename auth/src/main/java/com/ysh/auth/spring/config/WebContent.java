package com.ysh.auth.spring.config;


import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.ysh.auth.repository.converter.AuthorityReaderConverter;
import com.ysh.auth.repository.converter.AuthorityWriterConverter;

@Configuration
public class WebContent {
	
	@Bean
	public CustomConversions customConversions() {
		return new CustomConversions(Arrays.asList(new AuthorityReaderConverter(),
				new AuthorityWriterConverter()));
	}
	
}
