package com.example.BookDemo.Service;


import com.example.BookDemo.entity.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookDemo.dao.BookRepository;

@Component
public class BookService {
	
	@Autowired
	public BookRepository bookRepository;
	
	//getting all books
	public List<Book> getAllBooks(){
		
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		Collections.sort(list, (e1,e2) -> e1.getName().compareTo(e2.getName()));
		return list;
	}
	
	//getting single book by id 
	public Optional<Book> getBookById(int id) {
		Optional<Book> book=null;
		try {
			book=this.bookRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding book
	public Book addBook(Book b) {
		Book book=bookRepository.save(b);
		return book;
	}
	
	
	//update by id
	public Book updateBook(Book book) {
		Book oldBook=null;
		Optional<Book> optionalBook=bookRepository.findById(book.getId());
		if(optionalBook.isPresent()) {
			oldBook=optionalBook.get();
			oldBook.setName(book.getName());
			bookRepository.save(oldBook);
		}
		else {
			return new Book();
		}
		return oldBook;
	}
	//delete book
	public String deleteBookById(int id) {
		bookRepository.deleteById(id);
		return "Book got deleted";
	}
}
