package com.reactive.ReactiveProject.service;

import org.springframework.stereotype.Service;

import com.reactive.ReactiveProject.Entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface BookService {
	
	public Mono<Book> create(Book book);
	
	public Mono<Book> get(int bookId);
	
	public Flux<Book> getAll();
	
	public Mono<Book> updateBook(Book book , int bookId);
	
	public Mono<Void> deleteBook(int bookId);

	public Flux<Book> search(String query);
}
