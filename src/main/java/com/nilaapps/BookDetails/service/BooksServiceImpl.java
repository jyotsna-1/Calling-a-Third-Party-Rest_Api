package com.nilaapps.BookDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilaapps.BookDetails.dao.BooksDao;
import com.nilaapps.BookDetails.model.Books;

@Service
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BooksDao dao;

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

	@Override
	public int StoreBookDetails(Books books) {
		return dao.StoreBookDetails(books);
	}

	@Override
	public int deleteBook(String bookTitle) {
		// TODO Auto-generated method stub
		return dao.deleteBook(bookTitle);
	}

}
