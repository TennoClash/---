package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageInitController {

	@RequestMapping("/admin/index")
	public String aindex() {
		return "admin/index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/admin/main")
	public String amain() {
		return "admin/main";
	}
	
	@RequestMapping("/admin/orders")
	public String aorders() {
		return "admin/orders";
	}
	
	@RequestMapping("/admin/book")
	public String abook() {
		return "admin/book";
	}

	@RequestMapping("/admin/bookline")
	public String abookline() {
		return "admin/bookline";
	}

	@RequestMapping("/admin/ordersbar")
	public String aordersbar() {
		return "admin/ordersbar";
	}
	
	@RequestMapping("/saveimage")
	public String saveimage() {
		return "saveimage";
	}
}
