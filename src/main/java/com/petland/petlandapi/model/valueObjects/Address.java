package com.petland.petlandapi.model.valueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  @Column(name = "address_street")
  private String street;

  @Column(name = "address_number")
  private Integer number;
}
