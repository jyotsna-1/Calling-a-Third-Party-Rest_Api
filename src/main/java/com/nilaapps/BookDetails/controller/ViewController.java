package com.nilaapps.BookDetails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping(value="/home")
	public String home() {
		return "home";
	}

}
