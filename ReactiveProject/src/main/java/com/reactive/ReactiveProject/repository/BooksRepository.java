package com.reactive.ReactiveProject.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.ReactiveProject.Entity.Book;

@Repository
public interface BooksRepository extends ReactiveCrudRepository<Book, Integer>{

}
