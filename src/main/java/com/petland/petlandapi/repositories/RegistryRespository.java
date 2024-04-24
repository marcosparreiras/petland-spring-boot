package com.petland.petlandapi.repositories;

import com.petland.petlandapi.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistryRespository extends JpaRepository<Registry, Integer> {}
