package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.LendDto;
import com.unir.librarybrowser.domain.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

    @GetMapping
    ResponseEntity<PersonDto> getAll() {
        return ResponseEntity.ok(PersonDto.builder().build());
    }
}
