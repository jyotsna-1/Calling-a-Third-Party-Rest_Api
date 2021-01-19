package com.nilaapps.BookDetails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nilaapps.BookDetails.model.Books;

@Transactional
@Component
public class BooksDaoImpl implements BooksDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Books> getAllBooks() {
		String sql = "select * from BOOKS";
		List<Books> books = jdbcTemplate.query(sql, (rs,count) -> new Books(rs.getString("BOOK_TITLE"),
				rs.getString("AUTHOR"),
				rs.getInt("YEAR_PUBLISHED")));
		
		return books;
	}

	public int StoreBookDetails(Books books) {
		String sql = "insert into BOOKS values(?,?,?)";
		int affectedRow = jdbcTemplate.update(sql,books.getBookTitle(),books.getAuthor(),books.getPublishedYear());
		return affectedRow;
	}

	public int deleteBook(String bookTitle) {
		String sql = "delete BOOKS where BOOKTITLE=?";
		int affectedRow = jdbcTemplate.update(sql, bookTitle);
		return affectedRow;
	}

	

}
