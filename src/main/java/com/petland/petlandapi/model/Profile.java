package com.petland.petlandapi.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

  private boolean customer;
  private boolean supplier;
  private boolean provider;
}
