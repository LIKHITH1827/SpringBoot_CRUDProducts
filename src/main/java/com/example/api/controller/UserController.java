package com.example.api.controller;

import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Users;
import com.example.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		System.out.println(user);
		return userService.verify(user);
	}
}
