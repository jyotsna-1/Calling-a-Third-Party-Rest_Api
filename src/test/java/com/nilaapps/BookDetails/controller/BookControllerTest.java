package com.nilaapps.BookDetails.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nilaapps.BookDetails.model.Books;
import com.nilaapps.BookDetails.service.BooksService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=BooksController.class)
public class BookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BooksService service;
	
	@Test
	public void testGetAllBooks() throws Exception {

		Books mockBook1 = new Books();
		mockBook1.setBookTitle("ABC");
		mockBook1.setAuthor("ABC");
		mockBook1.setPublishedYear(2000);
		
		Books mockBook2 = new Books();
		mockBook2.setBookTitle("sgjg");
		mockBook2.setAuthor("fjgkj");
		mockBook2.setPublishedYear(2000); 
		
		List<Books> BookList = new ArrayList<>();
		BookList.add(mockBook1);
		BookList.add(mockBook2);
		
		Mockito.when(service.getAllBooks()).thenReturn(BookList);
		
		String URI = "/getBooks";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(BookList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	/**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
