package com.petland.petlandapi.controller;

import com.petland.petlandapi.model.Animal;
import com.petland.petlandapi.repositories.AnimalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  private AnimalRepository animalRepository;

  @GetMapping
  public List<Animal> index() {
    List<Animal> animals = this.animalRepository.findAll();
    return animals;
  }
}
