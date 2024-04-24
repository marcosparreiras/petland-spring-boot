package com.petland.petlandapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

  @Column(name = "profile_customer")
  private boolean customer;

  @Column(name = "profile_supplier")
  private boolean supplier;

  @Column(name = "profile_provider")
  private boolean provider;
}
