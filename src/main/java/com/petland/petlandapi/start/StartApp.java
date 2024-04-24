package com.petland.petlandapi.start;

import com.petland.petlandapi.model.Address;
import com.petland.petlandapi.model.Profile;
import com.petland.petlandapi.model.Registry;
import com.petland.petlandapi.repositories.RegistryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements ApplicationRunner {

  @Autowired
  private RegistryRespository registryRespository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Address address = new Address("Fransisco de sá", 451);
    Profile profile = new Profile(true, false, false);

    Registry marcos = new Registry();
    marcos.setName("Marcos");
    marcos.setAddress(address);
    marcos.setProfile(profile);

    this.registryRespository.save(marcos);
  }
}
