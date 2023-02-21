package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.service.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

  @Autowired
  private Book service;

  @GetMapping
  ResponseEntity<List<BookDto>> getAll() throws GenericException, NotFoundException {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping(value = "/get_by_id/{id}")
  ResponseEntity<BookDto> getById(@PathVariable(required = true) long id)
          throws GenericException, NotFoundException {
    return ResponseEntity.ok(service.getById(id));
  }

}
