package com.jesse.training.spring.config;

import com.jesse.training.spring.data.*;
import javax.annotation.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

@Profile("data")
@Configuration
public class DataProfileConfig {
  Logger logger = LoggerFactory.getLogger(DataProfileConfig.class);

  @Autowired
  private ApplicationContext appContext;

  @PostConstruct
  public void onInit() throws Exception {
    logger.info("onInit()");
    DataDB.initDataDB(appContext);
    DataDB.getInstance().getData(GroupData.class).initialize(appContext);
    DataDB.getInstance().getData(AccountData.class).initialize(appContext);
  }
}