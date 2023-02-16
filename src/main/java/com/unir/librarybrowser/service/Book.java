package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;

import java.util.List;

public interface Book {

    public List<BookDto> getAll() throws GenericException, NotFoundException;

    public BookDto getById(long id) throws GenericException, NotFoundException;

    public BookDto getByName(String name) throws GenericException, NotFoundException;

}
