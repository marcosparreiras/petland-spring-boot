package com.petland.petlandapi.model.dto;

import lombok.Data;

@Data
public class ProductServiceResponse {

  private String name;
  private Double value;
  private boolean service;
}
