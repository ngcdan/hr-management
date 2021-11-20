package com.jesse.training.spring.service;

import com.jesse.training.spring.entity.*;
import com.jesse.training.spring.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class AccountLogic {

  @Autowired
  private AccountRepository repo;

  public List<Account> findAll() {
    return null;
  }

  public Account getAccount(String loginId) {
    return repo.getAccountByLoginId(loginId);
  }

  public Account saveAccount(Account acc) {
    return repo.save(acc);
  }

  public boolean deleteAccountLoginById(String loginId) {
    return true;
  }
}