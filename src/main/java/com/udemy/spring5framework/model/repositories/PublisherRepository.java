package com.udemy.spring5framework.model.repositories;

import com.udemy.spring5framework.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
