package com.jesse.training.spring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "account_group",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = "path")
  },
  indexes = {
    @Index(columnList = "path")
  }
)
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor @Getter @Setter
public class AccountGroup extends AbstractPersistable<Long> {
  private static final long serialVersionUID = 1L;

  @NotNull
  private String name;

  @NotNull
  private String path;

  private String parentPath;

  public AccountGroup(AccountGroup parent, String name) {
    this.name = name;
    if (parent == null) {
      this.path = name;
    } else {
      parentPath = parent.getPath();
      path       = parent.getPath() + "/" + name;
    }
  }

  public AccountGroup withPath(String path) {
    this.path = path;
    return this;
  }

  public AccountGroup withParent(AccountGroup parent) {
    if (parent == null) {
      this.path       = this.name;
      this.parentPath = null;
    } else {
      path       = parent.getPath() + "/" + name;
      parentPath = parent.getPath();
    }
    return this;
  }
}