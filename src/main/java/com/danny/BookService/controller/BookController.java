package com.danny.BookService.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danny.BookService.model.Book;
import com.danny.BookService.service.BookService;

@RestController
public class BookController {

	@Autowired
	private Environment env;
	
	@Autowired
	private BookService service;
	
	@GetMapping(value="/")
	@ResponseStatus(HttpStatus.OK)
	public void gethealth(){
	}

	@GetMapping(value="/book")
	@ResponseStatus(HttpStatus.OK)
	public void gethealth2(){
		
	}
	
	@GetMapping(value="/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Book> getBooks(){
		return service.getBooksFromRepo();
	}
	
	@GetMapping(value="/new")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getNew(){
		return ResponseEntity.ok().body("New request update");
	}
	
	@GetMapping("/port")
	@ResponseStatus(HttpStatus.OK)
	public String getPort(RequestEntity<String> req, HttpServletRequest hreq) {
		StringBuilder builder = new StringBuilder();
		return builder.append("<h1> Remote Address =").append(hreq.getRemoteAddr()).append("</h1>").append("<h2> Request URL =").append(req.getUrl().toString()).append("</h2>").append("<br>").append("<h3> Server Port = ")
		.append(env.getProperty("local.server.port")).append("</h3>").toString();
	}
}
