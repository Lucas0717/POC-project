package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
// @RequestMapping(path = "/user")
public class UserController {
	
	
	private UserService userService;
	
	@RequestMapping("")
	public String firstPage() {
		return "index";
	}
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(path = "/register")
	public void register(@RequestBody User user) {
		userService.add(user);
	}
	
	@PostMapping(path = "/login")
	public void login(@RequestBody User user) {
		userService.authenticate(user);
	}
	
	@PostMapping(path = "/update")
	public void update(@RequestBody User user) {
		userService.update(user);
	}
	
	@GetMapping(path = "/search/{id}")
	public User searchById(@RequestParam Long id) {
		return userService.searchById(id);
	}
	
	@PostMapping(path = "/delete/{id}") 
	public void deleteById(@RequestParam Long id) {
		userService.deleteById(id);
	}
}
