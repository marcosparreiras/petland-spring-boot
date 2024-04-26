package com.petland.petlandapi.controller;

import com.petland.petlandapi.model.dto.AnimalRequest;
import com.petland.petlandapi.model.dto.AnimalResponse;
import com.petland.petlandapi.service.AnimalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  private AnimalService animalService;

  @GetMapping
  public ResponseEntity<Object> index() {
    List<AnimalResponse> animals = this.animalService.list();
    return ResponseEntity.ok().body(animals);
  }

  @PostMapping
  public ResponseEntity<Object> create(
    @RequestBody AnimalRequest animalRequest
  ) {
    Integer animalId = this.animalService.create(animalRequest);
    return ResponseEntity.status(201).body(animalId);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(
    @PathVariable Integer id,
    @RequestBody AnimalRequest animalRequest
  ) {
    try {
      this.animalService.update(id, animalRequest);
      return ResponseEntity.status(204).body(null);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }
}
