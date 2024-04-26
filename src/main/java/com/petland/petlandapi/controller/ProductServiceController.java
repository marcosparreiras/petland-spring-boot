package com.petland.petlandapi.controller;

import com.petland.petlandapi.model.entity.ProductServiceEntity;
import com.petland.petlandapi.repositories.ProductServiceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-service")
public class ProductServiceController {

  @Autowired
  private ProductServiceRepository productServiceRepository;

  public List<ProductServiceEntity> index() {
    List<ProductServiceEntity> productService =
      this.productServiceRepository.findAll();
    return productService;
  }
}
