package com.ndb.booksManagementBack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndb.booksManagementBack.model.User;
import com.ndb.booksManagementBack.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/login")
	Result login(@RequestBody User user, HttpSession session) {
		return userService.getUser(user, session);
	}
}
