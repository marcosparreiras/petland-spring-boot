package com.petland.petlandapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "registry")
public class Registry {

  @Id
  private Integer id;

  private String name;
  //private Profile profile;
  //private Address address;
}
