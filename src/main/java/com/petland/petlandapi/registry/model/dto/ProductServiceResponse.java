package com.petland.petlandapi.registry.model.dto;

import lombok.Data;

@Data
public class ProductServiceResponse {

  private String name;
  private Double value;
  private boolean service;
}
