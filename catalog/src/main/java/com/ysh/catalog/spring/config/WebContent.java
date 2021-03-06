package com.ysh.catalog.spring.config;

import javax.annotation.PreDestroy;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;


@RefreshScope
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@MapperScan("com.ysh.catalog.dao")
public class WebContent {

	@Autowired
	private DataSourceProperties dataSourceProperties;
	
	private final static String mapperLocations="classpath:mapper/*.xml"; 

	// database connection pool which decide the max connections and need be
	// closed(return the connection to the pool)
	private DataSource pool;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSourceProperties dsp = dataSourceProperties;

		this.pool = new DataSource();
		this.pool.setDriverClassName(dsp.getDriverClassName());
		this.pool.setUrl(dsp.getUrl());
		if (dsp.getUsername() != null) {
			this.pool.setUsername(dsp.getUsername());
		}
		if (dsp.getPassword() != null) {
			this.pool.setPassword(dsp.getPassword());
		}
		this.pool.setInitialSize(dsp.getInitialSize());
		this.pool.setMaxActive(dsp.getMaxActive());
		this.pool.setMaxIdle(dsp.getMaxIdle());
		this.pool.setMinIdle(dsp.getMinIdle());
		this.pool.setMaxWait(dsp.getMaxWait());
		this.pool.setRemoveAbandoned(dsp.isRemoveAbandoned());
		this.pool.setRemoveAbandonedTimeout(dsp.getRemoveAbandonedTimeout());
		return this.pool;
	}

	@PreDestroy
	public void close() {
		if (this.pool != null) {
			this.pool.close();
		}
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
		return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
	}


	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
