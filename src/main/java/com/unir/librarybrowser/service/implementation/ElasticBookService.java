package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.repository.ElasticSearchRepository;
import com.unir.librarybrowser.service.ElasticBook;
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
    List<ElasticBookEntity> all = repository.getAllBooks();
    return modelMapper.map(all, new TypeToken<List<ElasticBookDto>>() {
    }.getType());
  }

  /**
   * @param id
   * @return
   */
  @Override
  public ElasticBookDto getById(long id) throws NotFoundException {
    Optional<ElasticBookEntity> book = repository.getById(id);
    if (book.isEmpty()) {
      throw new NotFoundException("Not found any book for this id");
    }
    return modelMapper.map(book.get(), ElasticBookDto.class);
  }

  /**
   * @param name
   * @return
   */
  @Override
  public ElasticBookDto getByName(String name) throws NotFoundException {
    Optional<ElasticBookEntity> bookEntity = repository.getByName(name);
    if (bookEntity.isEmpty()) {
      throw new NotFoundException("Not found any book for this name");
    }
    return modelMapper.map(bookEntity.get(), ElasticBookDto.class);
  }

  /**
   * @param value
   * @return
   */
  @Override
  public ElasticBookDto searchByName(String value) throws NotFoundException {
    List<ElasticBookEntity> elasticBookEntities = repository.searchByName(value);
    if (elasticBookEntities.isEmpty()) {
      throw new NotFoundException("Not found any book for this name");
    }
    return modelMapper.map(elasticBookEntities, ElasticBookDto.class);
  }

  /**
   * @param value
   * @return
   */
  @Override
  public List<ElasticBookDto> searchBySynopsis(String value) {
    List<ElasticBookEntity> bookEntities = repository.searchBySynopsis(value);
    return modelMapper.map(bookEntities, new TypeToken<List<ElasticBookDto>>() {
    }.getType());
  }

  /**
   * @param request
   * @return
   */
  @Override
  public ElasticBookDto createBook(ElasticBookDto request) {
    ElasticBookEntity createdBookEntity = repository.saveBook(
        modelMapper.map(request, ElasticBookEntity.class));
    return modelMapper.map(createdBookEntity, ElasticBookDto.class);
  }
}
