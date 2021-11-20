package com.jesse.training.spring.service;

import com.jesse.training.spring.entity.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class AccountService {
  @Autowired
  private AccountLogic      accountLogic;

  @Autowired
  private AccountGroupLogic accountGroupLogic;

  public List<Account> findAllAccounts() {
    return accountLogic.findAll();
  }

  public Account getAccount(String loginId) {
    return accountLogic.getAccount(loginId);
  }

  public Account saveAccount(Account acc) {
    return accountLogic.saveAccount(acc);
  }

  public boolean deleteAccountByLoginId(String loginId) {
    return accountLogic.deleteAccountLoginById(loginId);
  }

  public List<AccountGroup> findAllAccountGroups() {
    return accountGroupLogic.findAll();
  }

  public AccountGroup getAccountGroup(String path) {
    return accountGroupLogic.getAccountGroupByPath(path);
  }

  public AccountGroup saveAccountGroup(AccountGroup gr) {
    return accountGroupLogic.saveAccountGroup(gr);
  }

  public int deleteAccountGroupByPath(String path) {
    return accountGroupLogic.deleteAccountGroupByPath(path);
  }

  public AccountMembership createAccountMembership(AccountMembership relation) {
    return accountGroupLogic.createAccountMembership(relation);
  }

  public int deleteAccountMembership(String loginId) {
    return accountGroupLogic.deleteAccountMembershipByLoginId(loginId);
  }
}