package com.reactive.ReactiveProject.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {

	@Id
	@Column("book_id")
	private Integer bookId;
	
	private String name;
	@Column("book_desc")
	private String description;
	private String publisher;
	private String Author;
	
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	@Override
	public String toString() {
		return "Book [BookId=" + bookId + ", name=" + name + ", description=" + description + ", publisher=" + publisher
				+ ", Author=" + Author + "]";
	}
	public Book(Integer bookId, String name, String description, String publisher, String author) {
		super();
		bookId = bookId;
		this.name = name;
		this.description = description;
		this.publisher = publisher;
		Author = author;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
