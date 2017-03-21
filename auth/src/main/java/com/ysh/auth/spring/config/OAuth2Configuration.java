package com.ysh.auth.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ysh.auth.service.MongoUserDetailsService;

@Configuration
public class OAuth2Configuration {
	
	
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
		
		@Autowired
	    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http
				.exceptionHandling()
					.authenticationEntryPoint(customAuthenticationEntryPoint)
				.and()
				.csrf()
					.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
						.disable()
					.headers()
						.frameOptions().disable()
				.and()
				.authorizeRequests()
					.antMatchers("/users/testClient")
						.permitAll()
					.antMatchers("/users/testSecureClient")
						.authenticated();
		}
	}
	
	@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

		private TokenStore tokenStore = new InMemoryTokenStore();

		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;

		@Autowired
		private MongoUserDetailsService userDetailsService;

		/*@Autowired
		private Environment env;*/

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

			// TODO persist clients details
			// @formatter:off
			clients.inMemory()
					.withClient("console")
					.authorizedGrantTypes("refresh_token", "password")
					.scopes("ui")
			.and()
					.withClient("order")
					.secret("order")
					.authorizedGrantTypes("client_credentials", "refresh_token")
					.scopes("server")
			.and()
					.withClient("auth")
					.secret("auth")
					.authorizedGrantTypes("password", "refresh_token")
					.scopes("server");
			// @formatter:on
		}
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints
					.tokenStore(tokenStore)
					.authenticationManager(authenticationManager);
//					.userDetailsService(userDetailsService);
		}
		
		/*@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer
					.tokenKeyAccess("permitAll()")
					.checkTokenAccess("isAuthenticated()");
		}*/
		
	}
}
