package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.repository.ElasticSearchRepository;
import com.unir.librarybrowser.service.ElasticBook;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ElasticBookService implements ElasticBook {

  private final ElasticSearchRepository repository;

  /**
   * @return
   */
  @Override
  public List<ElasticBookDto> getAll() {
    return repository.getAvaliableBooks();
  }

  /**
   * @param id
   * @return
   */
  @Override
  public ElasticBookDto getById(long id) {
    return repository.getById(id);
  }

  /**
   * @param name
   * @return
   */
  @Override
  public ElasticBookEntity getByName(String name) {
    return repository.getByName(name);
  }

  /**
   * @param value
   * @return
   */
  @Override
  public ElasticBookDto searchByName(String value) {
    return repository.searchByName(value);
  }

  /**
   * @param value
   * @return
   */
  @Override
  public List<ElasticBookDto> searchBySinopsis(String value) {
    return repository.searchBySynopsis(value);
  }
}
