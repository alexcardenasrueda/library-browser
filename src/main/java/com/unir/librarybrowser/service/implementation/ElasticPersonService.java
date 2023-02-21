package com.unir.librarybrowser.service.implementation;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.dto.ElasticPersonDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.domain.entity.ElasticPersonEntity;
import com.unir.librarybrowser.exception.NotFoundException;
import com.unir.librarybrowser.repository.ElasticSearchRepository;
import com.unir.librarybrowser.service.ElasticPerson;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticPersonService implements ElasticPerson {

  @Autowired
  private ElasticSearchRepository repository;

  @Autowired
  ModelMapper modelMapper;

  /**
   * @return
   */
  @Override
  public List<ElasticPersonDto> getAll() {
    List<ElasticBookEntity> all = repository.getAllBooks();
    return modelMapper.map(all, new TypeToken<List<ElasticBookDto>>() {
    }.getType());
  }

  /**
   * @param id
   * @return
   */
  @Override
  public ElasticPersonDto getById(long id) throws NotFoundException {
    Optional<ElasticBookEntity> book = repository.getById(id);
    if (book.isEmpty()) {
      throw new NotFoundException("Not found any book for this id");
    }
    return modelMapper.map(book.get(), ElasticPersonDto.class);
  }

  /**
   * @param name
   * @return
   */
  @Override
  public ElasticPersonDto getByName(String name) throws NotFoundException {
    Optional<ElasticBookEntity> bookEntity = repository.getByName(name);
    if (bookEntity.isEmpty()) {
      throw new NotFoundException("Not found any book for this name");
    }
    return modelMapper.map(bookEntity.get(), ElasticPersonDto.class);
  }

  /**
   * @param value
   * @return
   */
  @Override
  public ElasticPersonDto searchByName(String value) throws NotFoundException {
    List<ElasticBookEntity> elasticBookEntities = repository.searchByName(value);
    if (elasticBookEntities.isEmpty()) {
      throw new NotFoundException("Not found any book for this name");
    }
    return modelMapper.map(elasticBookEntities, ElasticPersonDto.class);
  }

  /**
   * @param request
   * @return
   */
  @Override
  public ElasticPersonDto createPerson(ElasticPersonDto request) {
    ElasticPersonEntity createdPersonEntity = repository.savePerson(
        modelMapper.map(request, ElasticPersonEntity.class));
    return modelMapper.map(createdPersonEntity, ElasticPersonDto.class);
  }
}
