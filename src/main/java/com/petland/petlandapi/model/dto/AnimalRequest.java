package com.petland.petlandapi.model.dto;

import com.petland.petlandapi.model.valueObjects.Species;
import java.time.LocalDate;
import lombok.Data;

@Data
public class AnimalRequest {

  private String name;
  private LocalDate birthDay;
  private Species species;
}
