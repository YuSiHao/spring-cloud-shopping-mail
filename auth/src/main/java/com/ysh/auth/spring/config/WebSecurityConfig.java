package com.ysh.auth.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ysh.auth.service.MongoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MongoUserDetailsService userDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();
	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		 @formatter:off
//					http
//						.authorizeRequests().anyRequest().authenticated()
//					.and()
//						.csrf().disable();
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
//	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService);
		// authenticationManagerBuilder
		// .inMemoryAuthentication()
		// .withUser("jack").password("123").roles("ADMIN");
		// .passwordEncoder(new BCryptPasswordEncoder());
	}

	// make authenticationManagerBuilder into bean
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	/*@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
	private static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
		@Override
		protected MethodSecurityExpressionHandler createExpressionHandler() {
			return new OAuth2MethodSecurityExpressionHandler();
		}

	}*/
	
}
