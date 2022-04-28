package com.example.BookDemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.BookDemo.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
