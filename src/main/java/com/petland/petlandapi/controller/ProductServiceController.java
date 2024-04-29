package com.petland.petlandapi.controller;

import com.petland.petlandapi.model.dto.ProductServiceResponse;
import com.petland.petlandapi.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-service")
public class ProductServiceController {

  @Autowired
  private ProductService productService;

  public ResponseEntity<Object> index() {
    List<ProductServiceResponse> products = this.productService.list();
    return ResponseEntity.ok().body(products);
  }
}
