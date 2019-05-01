package com.danny.BookService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BookService.model.Book;
import com.danny.BookService.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;
	
	public List<Book> getBooksFromRepo(){
		return repo.findAll();
	}
}
