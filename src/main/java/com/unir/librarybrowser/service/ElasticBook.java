package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import java.util.List;

public interface ElasticBook {

  List<ElasticBookDto> getBooks();

  ElasticBookDto getById(long id);

  ElasticBookDto getByName(String name);

  ElasticBookDto searchByName(String value);

  List<ElasticBookDto> searchBySynopsis(String value);
}
