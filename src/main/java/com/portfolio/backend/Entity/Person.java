package com.portfolio.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 1, message = "Not long enough")
  private String firstName;

  @NotNull
  @Size(min = 1, message = "Not long enough")
  private String lastName;

  @Size(min = 1, message = "Not long enough")
  private String imgUrl;

  @NotNull
  @Size(min = 1, message = "Not long enough")
  private String description;
}
