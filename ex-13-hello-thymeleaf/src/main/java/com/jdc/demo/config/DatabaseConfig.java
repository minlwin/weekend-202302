package com.jdc.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "emf" ,basePackages = "com.jdc.demo.repo")
@ComponentScan(basePackages = "com.jdc.demo.service")
public class DatabaseConfig {

	@Bean
	DataSource dataSource() {
		var bean = new BasicDataSource();
		bean.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bean.setUrl("jdbc:mysql://localhost:3306/finance");
		bean.setUsername("finance");
		bean.setPassword("finance");
		return bean;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean emf(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.demo.entity");
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setJpaPropertyMap(getJpaProperties());
		return bean;
	}

	private Map<String, Object> getJpaProperties() {
		var map = new HashMap<String, Object>();
		map.put("hibernate.hbm2ddl.auto", "create");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		return map;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
