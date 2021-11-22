package com.jesse.training.spring.repository;

import com.jesse.training.spring.entity.Account;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Serializable> {
  @Query("SELECT a FROM Account a WHERE a.loginId = :loginId")
  public Account getAccountByLoginId(@Param("loginId") String loginId);
}