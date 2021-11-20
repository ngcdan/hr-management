package com.jesse.training.spring.controller;

import com.jesse.training.spring.entity.*;
import com.jesse.training.spring.service.*;
import java.util.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1.0.0")
public class AccountController {
  @Autowired
  private AccountService accountService;

  @GetMapping("account/{loginId}")
  public @ResponseBody Account getAccount(@PathVariable("loginId") String loginId) {
    return accountService.getAccount(loginId);
  }

  @DeleteMapping("account/{id}")
  public @ResponseBody boolean deleteAccountById(@PathVariable("id") Long id) {
    return true;
  }

  @GetMapping("accounts")
  public @ResponseBody List<Account> findAllAccounts() {
    return accountService.findAllAccounts();
  }

  @PutMapping("account")
  public @ResponseBody Account saveAccount(@Valid @RequestBody Account account) {
    return accountService.saveAccount(account);
  }
}