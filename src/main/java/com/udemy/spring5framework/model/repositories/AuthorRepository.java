package com.udemy.spring5framework.model.repositories;

import com.udemy.spring5framework.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
