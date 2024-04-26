package com.petland.petlandapi.model.entity;

import com.petland.petlandapi.model.valueObjects.Address;
import com.petland.petlandapi.model.valueObjects.Profile;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Table(name = "registry")
public class RegistryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Integer id;

  private String name;

  @Embedded
  private Profile profile;

  @Embedded
  private Address address;
}
