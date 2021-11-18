package com.jesse.training.spring.config;

import javax.sql.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.jdbc.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;

@Configuration
@ComponentScan(basePackages = { "com.jesse.training.spring" })
@EnableJpaRepositories(basePackages = {"com.jesse.training.spring.repository"})
public class PersistenceConfiguration {
  @Bean
  public DataSource dataSource(
    @Value("${db.jdbc.driver:org.h2.Driver}") String jdbcDriver,
    @Value("${db.jdbc.url:jdbc:h2:mem:testdb}") String jdbcUrl,
    @Value("${db.jdbc.username:sa}")  String jdbcUser,
    @Value("${db.jdbc.password:}") String jdbcPassword) {
    DataSourceBuilder<?> builder = DataSourceBuilder.create();
    builder.driverClassName(jdbcDriver);
    builder.url(jdbcUrl);
    builder.username(jdbcUser);
    builder.password(jdbcPassword);
    return builder.build();
  }
}