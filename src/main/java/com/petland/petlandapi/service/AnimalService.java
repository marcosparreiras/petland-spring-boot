package com.petland.petlandapi.service;

import com.petland.petlandapi.model.entity.AnimalEntity;
import com.petland.petlandapi.repositories.AnimalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

  @Autowired
  private AnimalRepository animalRepository;

  public List<AnimalEntity> getAll() {
    List<AnimalEntity> animals = this.animalRepository.findAll();
    return animals;
  }
}
