package com.petland.petlandapi.registry.model.dto;

import com.petland.petlandapi.registry.model.valueObjects.Address;
import lombok.Data;

@Data
public class CostumerRequest {

  private String name;
  private Address address;
}
