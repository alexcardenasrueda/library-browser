package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;

import java.util.List;

public interface Person {

    public List<PersonDto> getAll() throws GenericException, NotFoundException;

    public PersonDto getById(long id) throws GenericException, NotFoundException;
}
