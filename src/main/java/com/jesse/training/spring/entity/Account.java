package com.jesse.training.spring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "account",
  uniqueConstraints = {
    @UniqueConstraint(
      columnNames = {"loginId"}
    )
  }, indexes = {
  @Index(columnList = "loginId")
})
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor @Setter @Getter
public class Account extends AbstractPersistable<Long> {
  private static final long serialVersionUID = 1L;
  static public enum AccountType { User, Organization }

  @Enumerated(EnumType.STRING)
  private AccountType accountType = AccountType.User;

  @NotNull
  private String loginId;
  private String password;

  private String email ;
  private String fullName;

  public Account(String loginId) {
    this.loginId = loginId;
  }

  public Account withEmail(String email) {
    this.email = email;
    return this;
  }

  public Account withFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public Account withAccountType(AccountType type) {
    this.accountType = type;
    return this;
  }
}