package com.udemy.spring5framework.bootstrap;

import com.udemy.spring5framework.model.Author;
import com.udemy.spring5framework.model.Book;
import com.udemy.spring5framework.model.Publisher;
import com.udemy.spring5framework.model.repositories.AuthorRepository;
import com.udemy.spring5framework.model.repositories.BookRepository;
import com.udemy.spring5framework.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Publisher manning = new Publisher("Manning Publications", "South Beach");
        publisherRepository.save(manning);

        Author fromm = new Author("Erich", "Fromm");
        Book escapeFreedom = new Book("Escape From Freedom", manning);
        fromm.getBooks().add(escapeFreedom);

        authorRepository.save(fromm);
        bookRepository.save(escapeFreedom);

        Author deries = new Author("Eric", "Deries");
        Book leanStartup = new Book("Lean Startup", manning);
        deries.getBooks().add(leanStartup);

        authorRepository.save(deries);
        bookRepository.save(leanStartup);

    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
