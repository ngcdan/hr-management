package com.jesse.training.spring.config;

import javax.annotation.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;

@Configuration
public class ProfileManagerConfig {
  private static final Logger logger = LoggerFactory.getLogger(ProfileManagerConfig.class);

  @Autowired
  private Environment env;

  @PostConstruct
  public void getActiveProfiles() {
    logger.info("Currently active profile: {}", String.join(" ", env.getActiveProfiles()));
  }
}