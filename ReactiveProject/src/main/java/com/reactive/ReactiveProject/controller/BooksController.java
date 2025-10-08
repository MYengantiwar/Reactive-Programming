package com.reactive.ReactiveProject.controller;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.ReactiveProject.Entity.Book;
import com.reactive.ReactiveProject.Entity.User;
import com.reactive.ReactiveProject.service.BookService;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/Books")
public class BooksController {

	@Autowired
	private BookService bookservice;
	
	
	@PostMapping
	public Mono<Book> createBook(@RequestBody Book book){
	
		return bookservice.create(book);
	}
	
	@GetMapping
	public Flux<Book> getAll(){
		return bookservice.getAll();
	}
	
	@GetMapping("/{bookId}")
	public Mono<Book> getBookById(@PathVariable int bookId){
		
		return bookservice.get(bookId);
	}
	
	@PutMapping("/{bookId}")
	public Mono<Book> updateBook(@RequestBody Book book ,@PathVariable int bookId){
		
		return bookservice.updateBook(book, bookId);
	}
	
	@DeleteMapping("/{BookId}")
	public void deleteBook(@PathVariable int BookId) {
		 bookservice.deleteBook(BookId);
	}
	
	@GetMapping("/fluxTransform")
	public List<String> fluxTransform(){
		List<String> result = new ArrayList<>();
		Flux<String> just = Flux.just("Mayur","Alex","Bobby" ,"Aman");
	    just.map(name -> name.toUpperCase()).filter( s -> s.startsWith("A")).subscribe( data ->{
			result.add(data);
		});
	    return result;
	}
	
	@GetMapping("/getUser")
	public void getUser(){
		User user = null;
		Disposable subscribe = Mono.justOrEmpty(user).switchIfEmpty(Mono.just(new User("Mayur", "Gadchiroli", "Maharashtra", "India"))).subscribe(
				users ->  {
					System.out.println("User="+users.toString());
				});
		
	}
	
	@GetMapping("/emitValues")
	public void emitValues() {
		
		Flux<Integer> delayElements = Flux.range(1, 10).delayElements(Duration.ofMillis(1000));
		delayElements.limitRequest(5).subscribe(s -> {
			System.out.println("Value ="+ s + " time="+Instant.now());
		}); 
	}
	
	@GetMapping("/handlezero")
	public void handlezero() {
		
		Flux<Integer> integerFlux = Flux.just(1,2,0,4);
		integerFlux.map(i -> 10/i).onErrorResume(t -> Mono.just(0) ).subscribe(s -> {
			System.out.println("Value of ="+s);
		});
	}
	
	@GetMapping("/firstlastname")
	public void firstlastname() {
		
		Flux<String> first = Flux.just("Mayur" , "Rohit");
		Flux<String> last = Flux.just("Yengantiwar" , "Power");
		
		Flux<Tuple2<String, String>> zipWith = first.zipWith(last);
		zipWith.subscribe(t -> {
			System.out.println(t.getT1() + " "+t.getT2());
		});
	}
	
	@GetMapping("/print")
	public void print() {
		Flux<Integer> range = Flux.range(1, 100).log();
		range.limitRequest(10).subscribe( t -> {
			System.out.println("Value is="+t);
		});
		
	}
	
	@GetMapping("/fluxBooks")
	public void getBooks(){
		
		Flux<Integer> id = Flux.range(1, 4);
		  id.flatMap( s ->  bookservice.get(s)).subscribe( System.out::println); 
	}
}
