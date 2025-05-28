package com.ndb.booksManagementBack.service;

import org.springframework.transaction.annotation.Transactional;

import com.ndb.booksManagementBack.controller.Result;
import com.ndb.booksManagementBack.model.User;

import jakarta.servlet.http.HttpSession;

@Transactional
public interface UserService {
	Result getUser(User user, HttpSession session);
}
