package com.petland.petlandapi.registry.repositories;

import com.petland.petlandapi.registry.model.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository
  extends JpaRepository<AnimalEntity, Integer> {}
