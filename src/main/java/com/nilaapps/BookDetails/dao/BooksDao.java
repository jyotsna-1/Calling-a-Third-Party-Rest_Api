package com.nilaapps.BookDetails.dao;

import java.util.List;

import com.nilaapps.BookDetails.model.Books;

public interface BooksDao {
	
	public List<Books> getAllBooks();
	
	public int StoreBookDetails(Books books);
	
	public int deleteBook(String bookTitle);

}
