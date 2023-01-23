package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.service.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private Book service;

    @GetMapping
    ResponseEntity<List<BookDto>> getAll() throws GenericException {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/get-by-id")
    ResponseEntity<BookDto> getById(@RequestParam(required = true, value = "id") long id) throws GenericException, NotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

}
