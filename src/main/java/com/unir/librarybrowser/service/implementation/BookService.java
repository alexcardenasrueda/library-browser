package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.BookDto;
import com.unir.librarybrowser.domain.entity.BookEntity;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.exception.GenericException;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.repository.BookRepository;
import com.unir.librarybrowser.repository.ElasticSearchRepository;
import com.unir.librarybrowser.service.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:constants.properties")
public class BookService implements Book {

  private final ElasticSearchRepository elasticsearchRepository;

  @Autowired
  BookRepository repository;

  @Autowired
  ModelMapper modelMapper;

  @Value("${exception.book.not_found_all}")
  private String bookNotFoundAll;

  @Value("${exception.book.not_found}")
  private String bookNotFound;

  /**
   * Find all library's books
   *
   * @return List of BookDto that contains simple object with book's specification
   */
  @Override
  public List<BookDto> getAll() throws GenericException, NotFoundException {
    List<BookDto> books = new ArrayList<>();

    try {
      List<BookEntity> allBooks = repository.findAll();
      if (allBooks == null || allBooks.isEmpty()) {
        throw new NotFoundException(bookNotFoundAll);
      }
      books = modelMapper.map(allBooks, new TypeToken<List<BookDto>>() {
      }.getType());
    } catch (RuntimeException e) {
      throw new GenericException(e.getMessage());
    }
    return books;
  }

  /**
   * Return one BookDto Object with book's information found by id
   *
   * @param id : Long number to find book in DB
   * @return BookDto object
   */
  @Override
  public BookDto getById(long id) throws GenericException, NotFoundException {
    BookDto book;
    try {
      Optional<BookEntity> entityBook = repository.findById(id);
      if (entityBook.isEmpty()) {
        throw new NotFoundException(MessageFormat.format(bookNotFound, id));
      }
      book = modelMapper.map(entityBook.get(), BookDto.class);
    } catch (RuntimeException e) {
      throw new GenericException(e.getMessage());
    }
    return book;
  }

  @Override
  public BookDto getByName(String name) throws GenericException, NotFoundException {
    ElasticBookEntity result = elasticsearchRepository.getByName(name);
    return new BookDto();
  }
}
