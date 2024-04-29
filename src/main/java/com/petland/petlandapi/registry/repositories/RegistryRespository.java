package com.petland.petlandapi.registry.repositories;

import com.petland.petlandapi.registry.model.entity.RegistryEntity;
import com.petland.petlandapi.registry.model.valueObjects.Profile;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryRespository
  extends JpaRepository<RegistryEntity, Integer> {
  List<RegistryEntity> findByProfile(Profile profile);
}
