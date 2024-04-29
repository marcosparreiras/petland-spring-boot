package com.petland.petlandapi.service.model.entity;

import com.petland.petlandapi.service.model.valueObjects.ServiceStatus;
import com.petland.petlandapi.service.model.valueObjects.ServiceType;
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
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "service")
@Data
public class ServiceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Integer id;

  private String description;
  private LocalDate date;
  private Double value;
  private boolean emergency;

  @Enumerated(EnumType.STRING)
  private ServiceStatus status;

  @Enumerated(EnumType.STRING)
  private ServiceType type;

  @Column(name = "product_service_id")
  private Integer productService;

  @Column(name = "animal_id")
  private Integer animal;

  @Column(name = "registry_id")
  private Integer registry;
}
