package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.service.Book;
import com.unir.librarybrowser.service.implementation.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private Book service;
    @GetMapping
    ResponseEntity<BookDto> getAll() throws GenericException {
        service.getAll();
        return ResponseEntity.ok(BookDto.builder().build());
    }

}
