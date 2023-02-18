package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticBookRepository extends ElasticsearchRepository<ElasticBookEntity, String> {

    Optional<ElasticBookEntity> findByName(String name);

    Optional<ElasticBookEntity> getById(long id);

    Optional<ElasticBookEntity> searchByName(String value);

    List<ElasticBookDto> getAvaliableBooks();

    List<ElasticBookDto> searchBySynopsis(String value);
}
