package com.reactive.ReactiveProject.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.ReactiveProject.Entity.Book;
import com.reactive.ReactiveProject.repository.BooksRepository;
import com.reactive.ReactiveProject.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepository bookrepo;
	
	@Override
	public Mono<Book> create(Book book) {
		// TODO Auto-generated method stub
		Mono<Book> savedbook = bookrepo.save(book);
		return savedbook;
	}

	@Override
	public Mono<Book> get(int bookId) {
		// TODO Auto-generated method stub
		Mono<Book> bookById = bookrepo.findById(bookId);
		return bookById;
	}

	@Override
	public Flux<Book> getAll() {
		// TODO Auto-generated method stub
		Flux<Book> allbook = bookrepo.findAll().delayElements(Duration.ofSeconds(2));
		return allbook;
	}

	@Override
	public Mono<Book> updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
		Mono<Book> oldBook = bookrepo.findById(bookId);
		return oldBook.flatMap(old -> {
			old.setAuthor(book.getAuthor());
			old.setDescription(book.getDescription());
			old.setName(book.getName());
			old.setPublisher(book.getPublisher());
			return bookrepo.save(old);
		});
		
	}

	@Override
	public Mono<Void> deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return bookrepo.findById(bookId).flatMap(books -> bookrepo.delete(books));
		
	}

	@Override
	public Flux<Book> search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
