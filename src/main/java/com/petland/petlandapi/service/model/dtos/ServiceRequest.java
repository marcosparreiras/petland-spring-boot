package com.petland.petlandapi.service.model.dtos;

import com.petland.petlandapi.service.model.valueObjects.ServiceStatus;
import com.petland.petlandapi.service.model.valueObjects.ServiceType;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ServiceRequest {

  private Integer id;

  private String description;
  private LocalDate date;
  private Double value;
  private boolean emergency;
  private ServiceStatus status;
  private ServiceType type;
  private Integer productService;
  private Integer animal;
  private Integer registry;
}
