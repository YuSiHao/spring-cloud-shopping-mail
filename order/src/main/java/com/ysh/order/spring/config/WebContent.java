package com.ysh.order.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.ConnectionProperties;

@Configuration
@EnableJpaRepositories(basePackages = "com.ysh.order.dao")
public class WebContent {

	@Value("${mysqldb.datasource.url}")
	private String MysqlUrl;

	@Value("${mysqldb.datasource.username}")
	private String Username;

	@Value("${mysqldb.datasource.password}")
	private String Password;

	@Value("${HIBERNATE_SHOW_SQL}")
	private String HIBERNATE_SHOW_SQL;
	
	@Value("${spring.datasource.type}")
	private String datasourceType;
	
	


	/**
	 * connect Redis
	 */
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("localhost");
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}
	
	@Bean
    public RedisTemplate<String, Object> redisTemplate() throws Exception {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

	@Bean(name = "dataSourceMySQL")
	public DruidDataSource dataSourceMySQL() {
		DruidDataSource source = new DruidDataSource();
		source.setUrl(MysqlUrl);
		System.out.println("MysqlUrl:"+MysqlUrl);
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUsername(Username);
		source.setPassword(Password);
		source.setDbType(datasourceType);
		return source;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSourceMySQL) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(dataSourceMySQL);
		return jpaTransactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSourceMySQL) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSourceMySQL);
		bean.setPackagesToScan("com.ysh.order.model");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		properties.setProperty("hibernate.format_sql", HIBERNATE_SHOW_SQL);
		properties.setProperty("hibernate.default_schema", "order");
		bean.setJpaProperties(properties);
		return bean;
	}

	public String getMysqlUrl() {
		return MysqlUrl;
	}

	public void setMysqlUrl(String mysqlUrl) {
		MysqlUrl = mysqlUrl;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getHIBERNATE_SHOW_SQL() {
		return HIBERNATE_SHOW_SQL;
	}

	public void setHIBERNATE_SHOW_SQL(String hIBERNATE_SHOW_SQL) {
		HIBERNATE_SHOW_SQL = hIBERNATE_SHOW_SQL;
	}

}
