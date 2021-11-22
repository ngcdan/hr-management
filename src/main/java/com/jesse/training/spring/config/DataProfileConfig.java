package com.jesse.training.spring.config;

import com.jesse.training.spring.data.AccountData;
import com.jesse.training.spring.data.DataDB;
import com.jesse.training.spring.data.GroupData;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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