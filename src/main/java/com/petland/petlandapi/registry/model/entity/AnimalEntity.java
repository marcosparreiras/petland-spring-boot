package com.petland.petlandapi.registry.model.entity;

import com.petland.petlandapi.registry.model.valueObjects.Species;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "animal")
@AllArgsConstructor
@NoArgsConstructor
public class AnimalEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Integer id;

  private String name;

  @Column(name = "birth_day")
  private LocalDate birthDay;

  @Enumerated(EnumType.STRING)
  private Species species;

  @Column(name = "registy_tutor")
  private Integer tutor;
}
