package com.jesse.training.spring;

import com.jesse.training.spring.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DerivedQueryTests {

  @Autowired
  private AccountRepository repo;

  @BeforeEach
  public void setUp() {
    repo.deleteAll();
  }






}