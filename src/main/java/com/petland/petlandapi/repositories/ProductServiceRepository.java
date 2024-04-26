package com.petland.petlandapi.repositories;

import com.petland.petlandapi.model.entity.ProductServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepository
  extends JpaRepository<ProductServiceEntity, Integer> {}
