package br.com.casadocodigo.loja.controllers;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

	@Bean // métodos criados em configurações precisam ser reconhecidos pelo Spring com "@Bean"
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = //cria meu EntityManagerFactory
							new LocalContainerEntityManagerFactoryBean(); 
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); 
		
		factoryBean.setJpaVendorAdapter(vendorAdapter);//implementação de JPA utilizada
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();//gerencia minha conexões
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		factoryBean.setDataSource(dataSource);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setJpaProperties(props);
		
		factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");
		
		return factoryBean;
		
	}
	@Bean
	JpaTransactionManager  transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
