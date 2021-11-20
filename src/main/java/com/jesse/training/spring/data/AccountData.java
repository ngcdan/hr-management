package com.jesse.training.spring.data;

import com.jesse.training.spring.entity.*;
import com.jesse.training.spring.entity.Account.*;
import com.jesse.training.spring.repository.*;
import org.springframework.context.*;

public class AccountData {
  public Account ADMIN;
  public Account DAN;

  public void initialize(ApplicationContext appContext) {
    GroupData GROUP = DataDB.getInstance().getData(GroupData.class);
    AccountRepository repo = appContext.getBean(AccountRepository.class);
    AccountMembershipRepository mRepo = appContext.getBean(AccountMembershipRepository.class);

    ADMIN = repo.save(createUser("admin"));
    mRepo.save(createMembership(ADMIN, GROUP.HR));
    mRepo.save(createMembership(ADMIN, GROUP.IT));

    DAN = repo.save(createUser("dan"));
    mRepo.save(createMembership(DAN, GROUP.IT));
  }

  static public Account createUser(String loginId) {
    Account user = new Account();
    user.setAccountType(AccountType.User);
    user.setLoginId(loginId);
    user.setPassword("password") ;
    user.setEmail(loginId + "@host") ;
    user.setFullName(loginId);
    return user ;
  }

  static public AccountMembership createMembership(Account account, AccountGroup group) {
    AccountMembership m = new AccountMembership();
    m.setLoginId(account.getLoginId());
    m.setGroupPath(group.getPath());
    return m;
  }
}