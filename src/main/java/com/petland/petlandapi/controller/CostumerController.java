package com.petland.petlandapi.controller;

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

  @GetMapping
  public ResponseEntity<Object> index() {
    // TODO
    return ResponseEntity.ok().body(null);
  }

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody Object body) {
    // TODO
    return ResponseEntity.status(201).body(null);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(
    @PathVariable Integer id,
    @RequestBody Object body
  ) {
    // TODO
    try {
      return ResponseEntity.status(204).body(null);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    // TODO
    return ResponseEntity.status(204).body(null);
  }
}
