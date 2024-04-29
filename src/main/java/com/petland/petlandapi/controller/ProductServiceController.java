package com.petland.petlandapi.controller;

import com.petland.petlandapi.model.dto.ProductServiceRequest;
import com.petland.petlandapi.model.dto.ProductServiceResponse;
import com.petland.petlandapi.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-service")
public class ProductServiceController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<Object> index() {
    List<ProductServiceResponse> products = this.productService.list();
    return ResponseEntity.ok().body(products);
  }

  @PostMapping
  public ResponseEntity<Object> create(
    @RequestBody ProductServiceRequest productServiceRequest
  ) {
    Integer productId = this.productService.create(productServiceRequest);
    return ResponseEntity.status(201).body(productId);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Object> update(
    @PathVariable Integer productId,
    @RequestBody ProductServiceRequest productServiceRequest
  ) {
    try {
      this.productService.update(productId, productServiceRequest);
      return ResponseEntity.status(204).body(null);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Object> delete(@PathVariable Integer productId) {
    try {
      this.productService.delete(productId);
      return ResponseEntity.status(204).body(null);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
