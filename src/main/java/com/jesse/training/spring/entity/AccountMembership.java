package com.jesse.training.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "account_membership",
  uniqueConstraints = {
    @UniqueConstraint(
      columnNames = {"loginId", "groupPath"}
    )
  }
)
@NoArgsConstructor @Setter @Getter
public class AccountMembership extends AbstractPersistable<Long>  {
  @NotNull
  public String loginId;
  @NotNull
  private String groupPath;

  public AccountMembership(String loginId, String groupPath) {
    this.loginId   = loginId;
    this.groupPath = groupPath;
  }
}