package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.domain.entity.PersonEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.repository.PersonRepository;
import com.unir.librarybrowser.service.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements Person {

    @Autowired
    PersonRepository repository;

    @Autowired
    ModelMapper modelMapper;

    /**
     * @return
     */
    @Override
    public List<PersonDto> getAll() throws GenericException {
        List<PersonDto> books = new ArrayList<>();
        try {
            List<PersonEntity> entityBooks = repository.findAll();
            books = modelMapper.map(entityBooks, new TypeToken<List<PersonDto>>() {
            }.getType());
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
        return books;
    }

    /**
     * @return
     */
    @Override
    public PersonDto getById() {
        return null;
    }
}
