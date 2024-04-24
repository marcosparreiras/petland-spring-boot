package com.petland.petlandapi.repositories;

import com.petland.petlandapi.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {}
