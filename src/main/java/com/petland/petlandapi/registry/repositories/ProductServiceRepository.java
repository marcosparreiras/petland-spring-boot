package com.petland.petlandapi.registry.repositories;

import com.petland.petlandapi.registry.model.entity.ProductServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepository
  extends JpaRepository<ProductServiceEntity, Integer> {}
