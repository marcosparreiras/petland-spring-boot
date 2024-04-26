package com.petland.petlandapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnimalResponse extends AnimalRequest {

  private Integer id;
}
