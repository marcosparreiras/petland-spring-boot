package com.petland.petlandapi.start;

import com.petland.petlandapi.model.Address;
import com.petland.petlandapi.model.Animal;
import com.petland.petlandapi.model.Profile;
import com.petland.petlandapi.model.Registry;
import com.petland.petlandapi.model.Species;
import com.petland.petlandapi.repositories.AnimalRepository;
import com.petland.petlandapi.repositories.RegistryRespository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements ApplicationRunner {

  @Autowired
  private RegistryRespository registryRespository;

  @Autowired
  private AnimalRepository animalRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Address address = new Address("Fransisco de sá", 451);
    Profile profile = new Profile(true, false, false);

    Registry marcos = new Registry();
    marcos.setName("Marcos");
    marcos.setAddress(address);
    marcos.setProfile(profile);

    this.registryRespository.save(marcos);

    Animal nestor = new Animal();
    nestor.setBirthDay(LocalDate.now());
    nestor.setName("Nestor");
    nestor.setSpecies(Species.DOG);

    this.animalRepository.save(nestor);
  }
}
