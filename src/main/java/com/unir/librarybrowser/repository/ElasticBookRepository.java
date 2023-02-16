package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.ElasticBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ElasticBookRepository extends ElasticsearchRepository<ElasticBook, String> {

    Optional<ElasticBook> findByName(String name);
}
