package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.dto.PersonDto;
import com.unir.librarybrowser.domain.entity.BookEntity;
import com.unir.librarybrowser.domain.entity.PersonEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.repository.BookRepository;
import com.unir.librarybrowser.repository.PersonRepository;
import com.unir.librarybrowser.service.Book;
import com.unir.librarybrowser.service.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements Book {

    @Autowired
    BookRepository repository;

    @Autowired
    ModelMapper modelMapper;

    /**
     * @return
     */
    @Override
    public List<BookDto> getAll() throws GenericException {
        List<BookDto> books = new ArrayList<>();

        try {
            List<BookEntity> entityBooks = repository.findAll();
            books = modelMapper.map(entityBooks, new TypeToken<List<PersonDto>>() {
            }.getType());
            throw new GenericException("Prueba de error 500");
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
    }

    /**
     * @return
     */
    @Override
    public BookDto getById(long id) {
        return null;
    }
}
