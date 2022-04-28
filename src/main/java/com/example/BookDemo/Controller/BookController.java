package com.example.BookDemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookDemo.Service.BookService;
import com.example.BookDemo.entity.Book;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/Books")
	public List<Book> getBooks(){
		
		List<Book> list=bookService.getAllBooks();
		return list;
	}
	@GetMapping("/Books/{id}")
	public Optional<Book> getbyid(@PathVariable("id") int id) {
		
		Optional<Book> book=bookService.getBookById(id);
		return book;
	}
	
	@PostMapping("/Books/addnew")
	public Book addBook(@RequestBody Book book){
		Book b=bookService.addBook(book);
		return b;
	}
	@PutMapping("/Update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/Delete/{id}")
	public String delete(@PathVariable int id) {
		return bookService.deleteBookById(id);
	}
}
