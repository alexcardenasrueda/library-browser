package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.domain.entity.BookEntity;
import com.unir.librarybrowser.domain.entity.PersonEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.repository.PersonRepository;
import com.unir.librarybrowser.service.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements Person {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ModelMapper modelMapper;

    @Value("${exception.person.not_found_all}")
    private String personNotFoundAll;

    @Value("${exception.person.not_found}")
    private String personNotFound;

    /**
     * @return
     */
    @Override
    public List<PersonDto> getAll() throws GenericException, NotFoundException {
        List<PersonDto> people = new ArrayList<>();

        try {
            List<PersonEntity> allPeople = personRepository.findAll();
            if (allPeople == null || allPeople.isEmpty()) {
                throw new NotFoundException(personNotFoundAll);
            }
            people = modelMapper.map(allPeople, new TypeToken<List<BookDto>>() {
            }.getType());
        } catch (RuntimeException e) {
            throw new GenericException(e.getMessage());
        }
        return people;
    }

    @Override
    public PersonDto getById(long id) throws GenericException, NotFoundException {
        PersonDto personDto;
        try {
            Optional<PersonEntity> personEntity = personRepository.findById(id);
            if (personEntity.isEmpty()) {
                throw new NotFoundException(MessageFormat.format(personNotFound, id));
            }
            personDto = modelMapper.map(personEntity.get(), PersonDto.class);
        } catch (RuntimeException e) {
            throw new GenericException(e.getMessage());
        }
        return personDto;
    }
}
