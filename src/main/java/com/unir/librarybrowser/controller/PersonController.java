package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.dto.LendDto;
import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.service.Book;
import com.unir.librarybrowser.service.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private Person personService;

    @GetMapping
    ResponseEntity<List<PersonDto>> getAll() throws GenericException, NotFoundException {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping(value = "/get_by_id/{id}")
    ResponseEntity<PersonDto> getById(@PathVariable(required = true) long id)
            throws GenericException, NotFoundException {
        return ResponseEntity.ok(personService.getById(id));
    }
}
