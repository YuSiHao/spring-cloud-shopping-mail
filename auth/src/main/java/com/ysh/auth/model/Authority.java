package com.ysh.auth.model;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Authority implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	
	private String authority;
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthority(){
		return authority;
	};
}
