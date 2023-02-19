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

    Optional<ElasticBookEntity> findById(long id);

    Optional<ElasticBookEntity> searchByName(String value);

    List<ElasticBookEntity> findAll();

    List<ElasticBookEntity> searchBySynopsis(String value);
}
