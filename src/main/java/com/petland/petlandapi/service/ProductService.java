package com.petland.petlandapi.service;

import com.petland.petlandapi.model.dto.ProductServiceRequest;
import com.petland.petlandapi.model.dto.ProductServiceResponse;
import com.petland.petlandapi.model.entity.ProductServiceEntity;
import com.petland.petlandapi.repositories.ProductServiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductServiceRepository productServiceRepository;

  public List<ProductServiceResponse> list() {
    List<ProductServiceEntity> productsEntity =
      this.productServiceRepository.findAll();
    List<ProductServiceResponse> productsResponse = productsEntity
      .stream()
      .map(productEntity -> {
        ProductServiceResponse productResponse = new ProductServiceResponse();
        BeanUtils.copyProperties(productEntity, productResponse);
        return productResponse;
      })
      .collect(Collectors.toList());
    return productsResponse;
  }

  public Integer create(ProductServiceRequest productServiceRequest) {
    ProductServiceEntity product = new ProductServiceEntity();
    BeanUtils.copyProperties(productServiceRequest, product);
    Integer productId = this.productServiceRepository.save(product).getId();
    return productId;
  }
}
