package com.jesse.training.spring;

import com.jesse.training.spring.config.PersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Import({PersistenceConfiguration.class})
public class TrainingSpringApplication {
  public static void main(String[] args) {
    SpringApplication.run(TrainingSpringApplication.class, args);
  }
}
