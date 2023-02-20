package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.exception.NotFoundException;
import java.util.List;

public interface ElasticBook {

  List<ElasticBookDto> getBooks();

  ElasticBookDto getById(long id) throws NotFoundException;

  ElasticBookDto getByName(String name) throws NotFoundException;

  ElasticBookDto searchByName(String value) throws NotFoundException;

  List<ElasticBookDto> searchBySynopsis(String value);

  ElasticBookDto createBook(ElasticBookDto request);
}
