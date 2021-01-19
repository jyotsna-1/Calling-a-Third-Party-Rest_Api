package com.nilaapps.BookDetails.model;

import org.springframework.stereotype.Component;

@Component
public class Books {
	
	private String bookTitle;
	private String author;
	private int publishedYear;
	
	public Books(String bookTitle, String author, int publishedYear) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.publishedYear = publishedYear;
	}
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	@Override
	public String toString() {
		return "Books [bookTitle=" + bookTitle + ", author=" + author + ", publishedYear=" + publishedYear + "]";
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

}
