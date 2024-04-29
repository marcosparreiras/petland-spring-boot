package com.petland.petlandapi.service.repository;

import com.petland.petlandapi.service.model.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRespository
  extends JpaRepository<ServiceEntity, Integer> {}
