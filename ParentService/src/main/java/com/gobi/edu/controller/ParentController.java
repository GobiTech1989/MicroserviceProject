package com.gobi.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gobi.edu.feign.ChildFeignClient;

@RestController
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	private ChildFeignClient childFeignClient;

	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to Parent Service!!!";
	}
	
	@GetMapping("/childMessage")
	public String getChildMessage() {
		return childFeignClient.getChildMessage();
	}
}
