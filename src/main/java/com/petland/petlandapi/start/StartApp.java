package com.petland.petlandapi.start;

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
    Registry marcos = new Registry();
    marcos.setId(1);
    marcos.setName("Marcos");

    this.registryRespository.save(marcos);
  }
}
