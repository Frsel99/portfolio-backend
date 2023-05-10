package com.portfolio.backend.Security.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.portfolio.backend.Security.Enums.RolName;

@Entity
public class Rol {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotNull
  @Enumerated(EnumType.STRING)
  private RolName rolName;

  public Rol() {
  }

  public Rol(RolName rolName) {
    this.rolName = rolName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public RolName getRolName() {
    return rolName;
  }

  public void setRolName(RolName rolName) {
    this.rolName = rolName;
  }

}