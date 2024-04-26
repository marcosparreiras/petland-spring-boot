package com.petland.petlandapi.model.dto;

import com.petland.petlandapi.model.valueObjects.Address;
import lombok.Data;

@Data
public class CostumerRequest {

  private String name;
  private Address address;
}
