package com.jesse.training.spring.data;

import com.jesse.training.spring.entity.*;
import com.jesse.training.spring.repository.*;
import org.springframework.context.*;

public class GroupData {
  public AccountGroup HR ;
  public AccountGroup IT ;
  public AccountGroup IT_DEVELOPER;

  public void initialize(ApplicationContext appContext) {
    AccountGroupRepository repo = appContext.getBean(AccountGroupRepository.class);

    HR = createAccountGroup(null, "hr");
    repo.save(HR);

    IT = createAccountGroup(null, "it");
    repo.save(IT);

    IT_DEVELOPER = createAccountGroup(IT, "developer");
    repo.save(IT_DEVELOPER);
  }

  static public AccountGroup createAccountGroup(AccountGroup parent, String name) {
    AccountGroup accGroup = new AccountGroup();
    accGroup.setName(name);
    accGroup.withParent(parent);
    return accGroup;
  }
}