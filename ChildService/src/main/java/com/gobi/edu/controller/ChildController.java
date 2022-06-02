package com.gobi.edu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/child")
public class ChildController {
	
	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/message")
	public String getChildMessage() {
		return "Welcome to Child Service!!!" + " ==> Child Port :: "+serverPort;
	}
}
