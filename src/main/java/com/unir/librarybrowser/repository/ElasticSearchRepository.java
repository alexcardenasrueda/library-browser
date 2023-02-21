package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import com.unir.librarybrowser.domain.entity.ElasticPersonEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchRepository {

  private final String[] nameSearchFields =
      {
          "name.search", "name.search_2gram", "name.search_3gram"
      };

  private final String[] synopsisSearchFields =
      {
          "synopsis.search", "synopsis.search_2gram", "synopsis.search_3gram"
      };
  @Autowired
  private ElasticBookRepository elasticBookRepository;
  @Autowired
  private ElasticPersonRepository elasticPersonRepository;
  @Autowired
  private ElasticsearchOperations elasticClient;

  public  Optional<ElasticBookEntity> getByName(String name) {
    return Optional.ofNullable(elasticBookRepository.findByName(name).orElse(null));
  }

  public List<ElasticBookEntity> getAllBooks() {
    return elasticBookRepository.findAll();
  }

  public Optional<ElasticBookEntity> getById(long id) {
    return elasticBookRepository.findById(id);
  }

  public List<ElasticBookEntity> searchByName(String value) {
    BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    boolQuery.must(QueryBuilders.multiMatchQuery(value,  nameSearchFields)
        .type(Type.BOOL_PREFIX));

    NativeSearchQueryBuilder nativeSearchQueryBuilder =
        new NativeSearchQueryBuilder().withQuery(boolQuery);

    Query query = nativeSearchQueryBuilder.build();

    SearchHits<ElasticBookEntity> result = elasticClient.search(query, ElasticBookEntity.class);

  return result.getSearchHits().stream().map(SearchHit:: getContent).collect(Collectors.toList());
  }

  public List<ElasticBookEntity> searchBySynopsis(String value) {
    BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    boolQuery.must(QueryBuilders.multiMatchQuery(value,  synopsisSearchFields)
        .type(Type.BOOL_PREFIX));

    NativeSearchQueryBuilder nativeSearchQueryBuilder =
        new NativeSearchQueryBuilder().withQuery(boolQuery);

    Query query = nativeSearchQueryBuilder.build();
    SearchHits<ElasticBookEntity> result = elasticClient.search(query, ElasticBookEntity.class);

    return result.getSearchHits().stream().map(SearchHit:: getContent).collect(Collectors.toList());
  }

  public ElasticBookEntity saveBook(ElasticBookEntity book){
    return elasticBookRepository.save(book);
  }

  public ElasticPersonEntity savePerson(ElasticPersonEntity person){
    return elasticPersonRepository.save(person);
  }
}
