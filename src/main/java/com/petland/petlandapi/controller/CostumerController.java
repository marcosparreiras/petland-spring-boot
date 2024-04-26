package com.petland.petlandapi.controller;

import com.petland.petlandapi.model.dto.CostumerRequest;
import com.petland.petlandapi.model.dto.CostumerResponse;
import com.petland.petlandapi.service.CostumerService;
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
@RequestMapping("/costumer")
public class CostumerController {

  @Autowired
  private CostumerService costumerService;

  @GetMapping
  public ResponseEntity<Object> index() {
    List<CostumerResponse> costumerResponses = this.costumerService.list();
    return ResponseEntity.ok().body(costumerResponses);
  }

  @PostMapping
  public ResponseEntity<Object> create(
    @RequestBody CostumerRequest costumerRequest
  ) {
    Integer costumerId = this.costumerService.create(costumerRequest);
    return ResponseEntity.status(201).body(costumerId);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(
    @PathVariable Integer id,
    @RequestBody CostumerRequest costumerRequest
  ) {
    try {
      this.costumerService.update(id, costumerRequest);
      return ResponseEntity.status(204).body(null);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    try {
      this.costumerService.delete(id);
      return ResponseEntity.status(204).body(null);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }
}
