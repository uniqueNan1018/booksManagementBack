package com.ndb.booksManagementBack.service.Impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndb.booksManagementBack.controller.Code;
import com.ndb.booksManagementBack.controller.Result;
import com.ndb.booksManagementBack.mapper.UserMapper;
import com.ndb.booksManagementBack.model.User;
import com.ndb.booksManagementBack.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;

	/**
	 * ユーザー情報検証
	 */
	@Override
	public Result getUser(User user, HttpSession session) {
		String username = user.getUsername();
		String rawPwd = user.getPassword();
		String password = DigestUtils.sha256Hex(rawPwd);
		Integer role = user.getRole();
		User reqUser = new User();
		reqUser.setUsername(username);
		reqUser.setPassword(password);
		reqUser.setRole(role);

		User resUser = userMapper.getUser(reqUser);
		if (resUser == null) {
			return new Result(Code.GET_ERROR, null);
		}
		session.setAttribute("userinfo", resUser);
		return new Result(Code.GET_OK, resUser);
	}

}
