package com.unir.librarybrowser.controller;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.dto.LendDto;
import com.unir.librarybrowser.domain.entity.LendEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.service.Lend;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lends")
@RequiredArgsConstructor
public class LendController {

    @Autowired
    private Lend lendService;

    @GetMapping
    ResponseEntity<List<LendDto>> getAll() throws GenericException {
        return ResponseEntity.ok(lendService.getAll());
    }

    @GetMapping(value = "/get_by_id/{id}")
    ResponseEntity<LendDto> getById(@PathVariable(required = true) long id)
            throws NotFoundException, GenericException {
        return ResponseEntity.ok(lendService.getById(id));
    }
}
