package com.nilaapps.BookDetails.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nilaapps.BookDetails.model.Books;
import com.nilaapps.BookDetails.service.BooksService;

@RestController
public class BooksController {
	
	@Autowired
	private BooksService service;
	
	@GetMapping(value="/getBooks", produces = "application/json;metacode=UTF-8")
	public ResponseEntity<List<Books>> getAllBooks(){
		
		return new ResponseEntity<List<Books>>(service.getAllBooks(),HttpStatus.OK);
		
	}
	
	@PostMapping(value="/addBook", produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> addBook(@RequestBody Books books){
		
		int affectedRow = service.StoreBookDetails(books);
		
		if(affectedRow == 0)
			return new ResponseEntity<String>(new Gson().toJson("OOPS, there is something mistake. Book can't be stored"),HttpStatus.OK);
		else
			return new ResponseEntity<>(new Gson().toJson("Book Details stored successfully"),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteBook", produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> deleteBook(@PathVariable String bookTitle){
		int affectedRow = service.deleteBook(bookTitle);
		
		if(affectedRow == 0)
			return new ResponseEntity<String>(new Gson().toJson("OOPS, there is something mistake. Book can't be deleted"),HttpStatus.OK);
		else
			return new ResponseEntity<>(new Gson().toJson("Book Details deleted successfully"),HttpStatus.OK); 		
	}

}
