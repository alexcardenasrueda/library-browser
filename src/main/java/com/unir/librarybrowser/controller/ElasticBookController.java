package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.service.ElasticBook;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elastic/books")
@RequiredArgsConstructor
public class ElasticBookController {

  private final ElasticBook service;

  @GetMapping
  public ResponseEntity<List<ElasticBookDto>> getAll(){
    List<ElasticBookDto> books = service.getAll();
    if (!Objects.nonNull(books)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(books);
  }

  @GetMapping(value = "/get_by_id/{id}")
  public ResponseEntity<ElasticBookDto> getById(@PathVariable(required = true) long id){
    ElasticBookDto book = service.getById(id);
    if (!Objects.nonNull(book)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/match/{name}")
  public ResponseEntity<ElasticBookEntity> getByName(@PathVariable(required = true) String name){
    ElasticBookEntity book = service.getByName(name);
    if (!Objects.nonNull(book)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/search/as_you_type/{value}")
  public ResponseEntity<ElasticBookDto> searchByName(@PathVariable(required = true) String value){
    ElasticBookDto book = service.searchByName(value);
    if (!Objects.nonNull(book)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/search/full-text/{value}")
  public ResponseEntity<List<ElasticBookDto>> searchBySynopsis(@PathVariable(required = true) String value){
    List<ElasticBookDto> books = service.searchBySinopsis(value);
    if (!Objects.nonNull(books)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(books);
  }
}
