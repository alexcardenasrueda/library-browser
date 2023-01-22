package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.LendEntity;
import com.unir.librarybrowser.domain.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LendRepository extends CrudRepository<LendEntity, Long> {

    List<LendEntity> findAll();
}
