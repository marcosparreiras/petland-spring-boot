package com.petland.petlandapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Profile {

  private boolean customer;
  private boolean supplier;
  private boolean provider;
}
