package com.danny.BookService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danny.BookService.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

}
