package com.petland.petlandapi.service.model.controllers;

import com.petland.petlandapi.service.model.dtos.ServiceRequest;
import com.petland.petlandapi.service.model.dtos.ServiceResponse;
import com.petland.petlandapi.service.service.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {

  @Autowired
  private ServiceService serviceService;

  @GetMapping
  public ResponseEntity<Object> index() {
    List<ServiceResponse> services = this.serviceService.list();
    return ResponseEntity.ok().body(services);
  }

  @PostMapping
  public ResponseEntity<Object> create(
    @RequestBody ServiceRequest serviceRequest
  ) {
    Integer serviceId = this.serviceService.create(serviceRequest);
    return ResponseEntity.status(201).body(serviceId);
  }
}
