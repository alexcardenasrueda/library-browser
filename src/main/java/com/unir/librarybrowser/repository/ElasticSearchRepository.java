package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ElasticSearchRepository {

  private final String[] nameSearchFields =
      {
          "name.search", "name.search_2gram", "name.search_3gram"
      };
  private final ElasticBookRepository elasticBookRepository;
  private final ElasticsearchOperations elasticClient;

  public ElasticBookEntity getByName(String name) {
    return elasticBookRepository.findByName(name).orElse(null);
  }

  public List<ElasticBookDto> getAvaliableBooks() {
    return null;
  }

  public ElasticBookDto getById(long id) {
    return null;
  }

  public ElasticBookDto searchByName(String value) {
    return null;
  }

  public List<ElasticBookDto> searchBySynopsis(String value) {
      return null;
  }
}
