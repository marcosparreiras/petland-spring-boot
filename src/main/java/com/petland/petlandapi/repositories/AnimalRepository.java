package com.petland.petlandapi.repositories;

import com.petland.petlandapi.model.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository
  extends JpaRepository<AnimalEntity, Integer> {}
