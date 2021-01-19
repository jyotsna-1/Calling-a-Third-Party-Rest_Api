package com.nilaapps.BookDetails.service;

import java.util.List;

import com.nilaapps.BookDetails.model.Books;

public interface BooksService {
	
	public List<Books> getAllBooks();
	
	public int StoreBookDetails(Books books);
	
	public int deleteBook(String bookTitle);

}
