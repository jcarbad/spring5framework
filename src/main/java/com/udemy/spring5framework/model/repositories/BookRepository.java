package com.udemy.spring5framework.model.repositories;

import com.udemy.spring5framework.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
