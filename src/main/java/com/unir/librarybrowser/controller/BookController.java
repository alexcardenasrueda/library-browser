package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @GetMapping
    ResponseEntity<BookDto> getAll() {
        return ResponseEntity.ok(BookDto.builder().build());
    }

}
