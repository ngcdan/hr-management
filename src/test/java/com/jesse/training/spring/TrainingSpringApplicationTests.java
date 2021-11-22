package com.jesse.training.spring;

import static org.assertj.core.api.Assertions.assertThat;

import com.jesse.training.spring.entity.Account;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrainingSpringApplicationTests {

  @Autowired
  private EntityManager entityManager;

  @Test
  void contextLoads() {
  }

  @Test
  public void verifyAccountCanBeSave() {
    final Account dan = new Account("dan")
      .withEmail("dan@host")
      .withFullName("Le Ngoc Dan");
    entityManager.persist(dan);

    TypedQuery<Account> results = entityManager.createQuery("SELECT a FROM Account a", Account.class);
    final List<Account> accounts = results.getResultList();
    assertThat(accounts).hasSize(1).first().isEqualTo(dan);
  }
}