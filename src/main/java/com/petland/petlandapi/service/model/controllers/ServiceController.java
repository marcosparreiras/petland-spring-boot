package com.petland.petlandapi.service.model.controllers;

import com.petland.petlandapi.service.model.dtos.ServiceResponse;
import com.petland.petlandapi.service.service.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
