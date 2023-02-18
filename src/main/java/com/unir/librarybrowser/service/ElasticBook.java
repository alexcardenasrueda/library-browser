package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.entity.ElasticBookEntity;
import java.util.List;

public interface ElasticBook {

  List<ElasticBookDto> getAll();

  ElasticBookDto getById(long id);

  ElasticBookEntity getByName(String name);

  ElasticBookDto searchByName(String value);

  List<ElasticBookDto> searchBySinopsis(String value);
}
