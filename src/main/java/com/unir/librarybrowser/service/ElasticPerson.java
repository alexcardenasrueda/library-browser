package com.unir.librarybrowser.service;

import com.unir.librarybrowser.domain.dto.ElasticBookDto;
import com.unir.librarybrowser.domain.dto.ElasticPersonDto;
import com.unir.librarybrowser.exception.NotFoundException;
import java.util.List;

public interface ElasticPerson {

  List<ElasticPersonDto> getAll();

  ElasticPersonDto getById(long id) throws NotFoundException;

  ElasticPersonDto getByName(String name) throws NotFoundException;

  ElasticPersonDto searchByName(String value) throws NotFoundException;

  ElasticPersonDto createPerson(ElasticPersonDto request);
}
