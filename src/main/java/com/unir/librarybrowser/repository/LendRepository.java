package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.LendEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LendRepository extends CrudRepository<LendEntity, Long> {

    List<LendEntity> findAll();

    Optional<LendEntity> findById(Long id);
}
