package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.ElasticBook;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ElasticSearchRepository {

    private final ElasticBookRepository elasticBookRepository;
    private final ElasticsearchOperations elasticClient;

    public ElasticBook getByName(String name){
        return elasticBookRepository.findByName(name).orElse(null);
    }
}
