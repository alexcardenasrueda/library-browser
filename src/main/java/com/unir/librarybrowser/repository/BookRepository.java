package com.unir.librarybrowser.repository;

import com.unir.librarybrowser.domain.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAll();

    @Override
    Optional<BookEntity> findById(Long aLong);
}
