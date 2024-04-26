package com.petland.petlandapi.service;

import com.petland.petlandapi.model.dto.AnimalRequest;
import com.petland.petlandapi.model.dto.AnimalResponse;
import com.petland.petlandapi.model.entity.AnimalEntity;
import com.petland.petlandapi.repositories.AnimalRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

  @Autowired
  private AnimalRepository animalRepository;

  public List<AnimalResponse> list() {
    List<AnimalEntity> animalsEntity = this.animalRepository.findAll();
    List<AnimalResponse> animalsResponse = animalsEntity
      .stream()
      .map(animalEntity -> {
        AnimalResponse animalResponse = new AnimalResponse();
        BeanUtils.copyProperties(animalEntity, animalResponse);
        return animalResponse;
      })
      .collect(Collectors.toList());
    return animalsResponse;
  }

  public void create(AnimalRequest animalRequest) {
    AnimalEntity animalEntity = new AnimalEntity();
    animalEntity.setName(animalRequest.getName());
    animalEntity.setBirthDay(animalRequest.getBirthDay());
    animalEntity.setSpecies(animalRequest.getSpecies());
    this.animalRepository.save(animalEntity);
  }
}
