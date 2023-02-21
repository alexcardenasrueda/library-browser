package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.ElasticPersonEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticPersonRepository extends ElasticsearchRepository<ElasticPersonEntity, String> {

    Optional<ElasticPersonEntity> findByName(String name);

    Optional<ElasticPersonEntity> findById(long id);

    Optional<ElasticPersonEntity> searchByName(String value);

    List<ElasticPersonEntity> findAll();
}
