package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.service.ElasticBook;
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
@RequestMapping("/elastic/books")
@CrossOrigin
public class ElasticBookController {

  @Autowired
  private ElasticBook service;

  @GetMapping
  public ResponseEntity<List<ElasticBookDto>> getBooks(){
    List<ElasticBookDto> books = service.getBooks();
    if (!Objects.nonNull(books)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(books);
  }

  @GetMapping(value = "/get_by_id/{id}")
  public ResponseEntity<ElasticBookDto> getById(@PathVariable(required = true) long id)
      throws NotFoundException {
    ElasticBookDto book = service.getById(id);
    if (!Objects.nonNull(book)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/match/{name}")
  public ResponseEntity<ElasticBookDto> getByName(@PathVariable(required = true) String name)
      throws NotFoundException {
    ElasticBookDto book = service.getByName(name);
    if (!Objects.nonNull(book)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/search_as_you_type/{value}")
  public ResponseEntity<ElasticBookDto> searchByName(@PathVariable(required = true) String value)
      throws NotFoundException {
    ElasticBookDto book = service.searchByName(value);
    if (!Objects.nonNull(book)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/search/full-text/{value}")
  public ResponseEntity<List<ElasticBookDto>> searchBySynopsis(@PathVariable(required = true) String value){
    List<ElasticBookDto> books = service.searchBySynopsis(value);
    if (!Objects.nonNull(books)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(books);
  }

  @PostMapping
  public ResponseEntity<ElasticBookDto> createBook(@RequestBody ElasticBookDto request){
      ElasticBookDto createdBook = service.createBook(request);
    if (!Objects.nonNull(createdBook)){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(createdBook);
  }
}
