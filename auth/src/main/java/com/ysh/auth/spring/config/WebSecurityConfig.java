package com.ysh.auth.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.ysh.auth.service.MongoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MongoUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
					http
						.authorizeRequests().anyRequest().authenticated()
					.and()
						.csrf().disable();
					// @formatter:on
		
//		http.
//			csrf().
//				disable()
//			.authorizeRequests()
//				.antMatchers("/forAdmin/*")
//				.hasRole("ADMIN")
//				.and()
//			.authorizeRequests()	
//			.anyRequest()
//				.authenticated()
//				.and()
//			.formLogin()
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll()
//				.and().
//			sessionManagement().
//				sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService);
//		authenticationManagerBuilder
//         	.inMemoryAuthentication()
//             	.withUser("jack").password("123").roles("ADMIN");
//				.passwordEncoder(new BCryptPasswordEncoder());
	}

	// make authenticationManagerBuilder into bean
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
