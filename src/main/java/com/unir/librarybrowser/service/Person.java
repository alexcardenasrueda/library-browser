package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.exception.GenericException;

import java.util.List;

public interface Person {

    public List<PersonDto> getAll() throws GenericException;

    public PersonDto getById(long id);
}
