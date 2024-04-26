package com.petland.petlandapi.service;

import com.petland.petlandapi.model.dto.CostumerRequest;
import com.petland.petlandapi.model.dto.CostumerResponse;
import com.petland.petlandapi.model.entity.RegistryEntity;
import com.petland.petlandapi.model.valueObjects.Profile;
import com.petland.petlandapi.repositories.RegistryRespository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

  @Autowired
  private RegistryRespository registryRespository;

  private Profile profile = new Profile(true, false, false);

  public List<CostumerResponse> list() {
    List<RegistryEntity> costumersEntity =
      this.registryRespository.findByProfile(this.profile);
    List<CostumerResponse> costumersResponse = costumersEntity
      .stream()
      .map(costumerEntity -> {
        CostumerResponse costumerResponse = new CostumerResponse();
        BeanUtils.copyProperties(costumerEntity, costumerResponse);
        return costumerResponse;
      })
      .collect(Collectors.toList());
    return costumersResponse;
  }

  public Integer create(CostumerRequest costumerRequest) {
    RegistryEntity costumerEntity = new RegistryEntity();
    costumerEntity.setProfile(this.profile);
    BeanUtils.copyProperties(costumerRequest, costumerEntity);
    Integer costumerId = this.registryRespository.save(costumerEntity).getId();
    return costumerId;
  }

  public void update(Integer costumerId, CostumerRequest costumerRequest)
    throws Exception {
    RegistryEntity costumerEntity =
      this.registryRespository.findById(costumerId).orElse(null);
    if (costumerEntity == null || !costumerEntity.getProfile().isCustomer()) {
      throw new Exception("Costumer not found");
    }
    BeanUtils.copyProperties(costumerRequest, costumerEntity);
    this.registryRespository.save(costumerEntity);
  }

  public void delete(Integer costumerId) throws Exception {
    RegistryEntity costumerEntity =
      this.registryRespository.findById(costumerId).orElse(null);
    if (costumerEntity == null || !costumerEntity.getProfile().isCustomer()) {
      throw new Exception("Costumer not found");
    }
    this.registryRespository.delete(costumerEntity);
  }
}
