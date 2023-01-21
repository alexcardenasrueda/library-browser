package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    List<PersonEntity> findAll();
}
