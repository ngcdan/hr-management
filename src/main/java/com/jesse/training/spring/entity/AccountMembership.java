package com.jesse.training.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

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