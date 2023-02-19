package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchRepository {

  private final String[] nameSearchFields =
      {
          "name.search", "name.search_2gram", "name.search_3gram"
      };
  @Autowired
  private ElasticBookRepository elasticBookRepository;
  @Autowired
  private ElasticsearchOperations elasticClient;

  public ElasticBookEntity getByName(String name) {
    return elasticBookRepository.findByName(name).orElse(null);
  }

  public List<ElasticBookEntity> getAll() {
    return elasticBookRepository.findAll();
  }

  public Optional<ElasticBookEntity> getById(long id) {
    return elasticBookRepository.findById(id);
  }

  public Optional<ElasticBookEntity> searchByName(String value) {
    return elasticBookRepository.searchByName(value);
  }

  public List<ElasticBookEntity> searchBySynopsis(String value) {
      return elasticBookRepository.searchBySynopsis(value);
  }
}
