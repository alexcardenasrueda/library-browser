package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.ElasticPersonDto;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.service.ElasticPerson;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elastic/people")
@CrossOrigin
public class ElasticPersonController {

  @Autowired
  private ElasticPerson service;

  @GetMapping
  public ResponseEntity<List<ElasticPersonDto>> getAll() {
    List<ElasticPersonDto> users = service.getAll();
    if (!Objects.nonNull(users)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(users);
  }

  @GetMapping(value = "/get_by_id/{id}")
  public ResponseEntity<ElasticPersonDto> getById(@PathVariable(required = true) long id)
      throws NotFoundException {
    ElasticPersonDto book = service.getById(id);
    if (!Objects.nonNull(book)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/match/{name}")
  public ResponseEntity<ElasticPersonDto> getByName(@PathVariable(required = true) String name)
      throws NotFoundException {
    ElasticPersonDto book = service.getByName(name);
    if (!Objects.nonNull(book)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/search_as_you_type/{value}")
  public ResponseEntity<ElasticPersonDto> searchByName(@PathVariable(required = true) String value)
      throws NotFoundException {
    ElasticPersonDto book = service.searchByName(value);
    if (!Objects.nonNull(book)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @PostMapping
  public ResponseEntity<ElasticPersonDto> createPerson(@RequestBody ElasticPersonDto request) {
    ElasticPersonDto createdPerson = service.createPerson(request);
    if (!Objects.nonNull(createdPerson)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(createdPerson);
  }
}
