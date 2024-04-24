package com.petland.petlandapi.repositories;

import com.petland.petlandapi.model.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepository
  extends JpaRepository<ProductService, Integer> {}
