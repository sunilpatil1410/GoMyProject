package com.globeop.riskfeed.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:userDB.properties"})
@EnableJpaRepositories(basePackages={"${spring.data.jpa.user.repository.packages}"},
entityManagerFactoryRef = "userEntityManagerFactory",
transactionManagerRef = "userTransactionManager")

/*@Configuration
@PropertySource({"classpath:persistence-multiple-db-boot.properties"})
@EnableJpaRepositories(
  basePackages = "com.baeldung.multipledb.dao.user",
  entityManagerFactoryRef = "userEntityManager",
  transactionManagerRef = "userTransactionManager")*/
public class UserConfig {

	//@Primary
	@Bean(name="securityDB")
	@ConfigurationProperties(prefix="security.datasource")
	public DataSource securityDataSource() {
		System.out.println(" <<<<<<<<<<<<<< security.datasource >>>>>>>>>>");
		return DataSourceBuilder.create().build();
	}
	
	//@Primary
	@Bean(name="userEntityManagerFactory")
	@ConfigurationProperties(prefix="spring.data.jpa.user.entity")
	//@Qualifier("securityDBentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("securityDB") DataSource securityDataSource) {
		return builder
				//.dataSource(securityDataSource)
				.dataSource(securityDataSource)
				.packages("${spring.data.jpa.user.repository.packages}")
				.persistenceUnit("securityDataSource")
				.build();
	}
	
	
	 //@Primary	  
	 @Bean(name="userTransactionManager") 
	 public PlatformTransactionManager transactionManager(@Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory) { 
		 return new JpaTransactionManager(entityManagerFactory); 
	 }
	 
}
