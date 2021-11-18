package com.jesse.training.spring;

import com.jesse.training.spring.config.*;
import org.slf4j.*;
import org.springframework.boot.Banner.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.security.servlet.*;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TrainingSpringApplication {
  private static final Logger logger = LoggerFactory.getLogger(TrainingSpringApplication.class);

  public static void main(String[] args) {
    logger.info("Launch ServerApp with args: {}", String.join(" ", args));

    Class<?>[] source = {TrainingSpringApplication.class, PersistenceConfiguration.class, ProfileManagerConfig.class};

    SpringApplication app = new SpringApplication(source);
    app.setBannerMode(Mode.OFF);
    app.run(args);
  }
}