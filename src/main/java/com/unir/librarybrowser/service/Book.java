package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.exception.GenericException;

import java.util.List;

public interface Book {

    public List<BookDto> getAll() throws GenericException;

    public BookDto getById(long id);
}
