package com.jesse.training.spring.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

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