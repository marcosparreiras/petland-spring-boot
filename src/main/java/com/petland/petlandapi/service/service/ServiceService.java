package com.petland.petlandapi.service.service;

import com.petland.petlandapi.service.model.dtos.ServiceRequest;
import com.petland.petlandapi.service.model.dtos.ServiceResponse;
import com.petland.petlandapi.service.model.entity.ServiceEntity;
import com.petland.petlandapi.service.repository.ServiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

  @Autowired
  private ServiceRepository serviceRepository;

  public List<ServiceResponse> list() {
    List<ServiceEntity> servicesEntity = this.serviceRepository.findAll();
    List<ServiceResponse> servicesResponse = servicesEntity
      .stream()
      .map(serviceEntity -> {
        ServiceResponse serviceResponse = new ServiceResponse();
        BeanUtils.copyProperties(serviceEntity, serviceResponse);
        return serviceResponse;
      })
      .collect(Collectors.toList());
    return servicesResponse;
  }

  public Integer create(ServiceRequest serviceRequest) {
    ServiceEntity serviceEntity = new ServiceEntity();
    BeanUtils.copyProperties(serviceRequest, serviceEntity);
    Integer serviceId = this.serviceRepository.save(serviceEntity).getId();
    return serviceId;
  }
}
