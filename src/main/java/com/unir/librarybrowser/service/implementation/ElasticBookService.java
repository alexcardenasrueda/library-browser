package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.repository.ElasticSearchRepository;
import com.unir.librarybrowser.service.ElasticBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticBookService implements ElasticBook {

  @Autowired
  private ElasticSearchRepository repository;

  @Autowired
  ModelMapper modelMapper;

  /**
   * @return
   */
  @Override
  public List<ElasticBookDto> getBooks() {
    List<ElasticBookEntity> all = repository.getAll();
    return modelMapper.map(all, new TypeToken<List<ElasticBookDto>>() {}.getType());
  }

  /**
   * @param id
   * @return
   */
  @Override
  public ElasticBookDto getById(long id) {
    ElasticBookDto bookDto = ElasticBookDto.builder().build();
    Optional<ElasticBookEntity> book = repository.getById(id);
    return bookDto;
  }

  /**
   * @param name
   * @return
   */
  @Override
  public ElasticBookDto getByName(String name) {
    ElasticBookDto bookDto = ElasticBookDto.builder().build();
    ElasticBookEntity bookEntity = repository.getByName(name);
    return bookDto;
  }

  /**
   * @param value
   * @return
   */
  @Override
  public ElasticBookDto searchByName(String value) {
    ElasticBookDto bookDto = ElasticBookDto.builder().build();
    Optional<ElasticBookEntity> OptionalBookEntity = repository.searchByName(value);
    return bookDto;
  }

  /**
   * @param value
   * @return
   */
  @Override
  public List<ElasticBookDto> searchBySynopsis(String value) {
    List<ElasticBookDto> bookDtos = new ArrayList<>();
    List<ElasticBookEntity> bookEntities = repository.searchBySynopsis(value);
    return bookDtos;
  }
}
