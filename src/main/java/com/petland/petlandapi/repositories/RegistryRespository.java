package com.petland.petlandapi.repositories;

import com.petland.petlandapi.model.entity.RegistryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryRespository
  extends JpaRepository<RegistryEntity, Integer> {}
