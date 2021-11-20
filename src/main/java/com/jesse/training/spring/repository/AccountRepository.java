package com.jesse.training.spring.repository;

import com.jesse.training.spring.entity.*;
import java.io.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface AccountRepository extends JpaRepository<Account, Serializable> {
  @Query("SELECT a FROM Account a WHERE a.loginId = :loginId")
  public Account getAccountByLoginId(@Param("loginId") String loginId);
}