package com.jesse.training.spring;

import com.jesse.training.spring.config.PersistenceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TrainingSpringApplication {
  private static final Logger logger = LoggerFactory.getLogger(TrainingSpringApplication.class);

  public static void main(String[] args) {
    logger.info("Launch ServerApp with args: {}", String.join(" ", args));

    Class<?>[] source = {TrainingSpringApplication.class, PersistenceConfiguration.class};

    SpringApplication app = new SpringApplication(source);
    app.setBannerMode(Mode.OFF);
    app.run(args);
  }
}