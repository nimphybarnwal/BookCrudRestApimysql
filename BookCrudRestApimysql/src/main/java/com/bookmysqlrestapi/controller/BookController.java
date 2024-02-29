package com.bookmysqlrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmysqlrestapi.entity.Book;
import com.bookmysqlrestapi.exception.ResourceNotFoundException;
import com.bookmysqlrestapi.repository.BookRepo;

@RestController
@RequestMapping("/api")
public class BookController
{
	@Autowired
	BookRepo bookRepo;
	
	//get all Books
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
  //post all book
	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody Book book)
	{
		return bookRepo.save(book);
	}
	
	//Get by Id 
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable(value="id") Integer bookId)
	{
	
		return bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book","id",bookId));
	}
	
	//put update Book 
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable(value="id") Integer bookId,@Valid @RequestBody Book bookDetails)
	{
		Book book=bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book","id",bookId));
	     
		book.setBookTitle(bookDetails.getBookTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setPublication(bookDetails.getPublication());
		book.setPrice(bookDetails.getPrice());
		book.setNoOfPages(bookDetails.getNoOfPages());
		
		Book updateBook= bookRepo.save(book);
		return updateBook;
	}
	
	// delete
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value="id") Integer bookId)
	{   
		Book book=bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book","id",bookId));
		bookRepo.delete(book);
		
		return ResponseEntity.ok().build();
	}
}
