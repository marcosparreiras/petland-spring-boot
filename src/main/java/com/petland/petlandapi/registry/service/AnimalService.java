package com.petland.petlandapi.registry.service;

import com.petland.petlandapi.registry.model.dto.AnimalRequest;
import com.petland.petlandapi.registry.model.dto.AnimalResponse;
import com.petland.petlandapi.registry.model.entity.AnimalEntity;
import com.petland.petlandapi.registry.repositories.AnimalRepository;
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

  public Integer create(AnimalRequest animalRequest) {
    AnimalEntity animalEntity = new AnimalEntity();
    BeanUtils.copyProperties(animalRequest, animalEntity);
    Integer animalId = this.animalRepository.save(animalEntity).getId();
    return animalId;
  }

  public void update(Integer animalId, AnimalRequest animalRequest)
    throws Exception {
    AnimalEntity animalEntity =
      this.animalRepository.findById(animalId).orElse(null);
    if (animalEntity == null) {
      throw new Exception("Animal not found");
    }
    BeanUtils.copyProperties(animalRequest, animalEntity);
    this.animalRepository.save(animalEntity);
  }

  public void delete(Integer animalId) throws Exception {
    AnimalEntity animalEntity =
      this.animalRepository.findById(animalId).orElse(null);
    if (animalEntity == null) {
      throw new Exception("Animal not found");
    }
    this.animalRepository.delete(animalEntity);
  }
}
