package com.ndb.booksManagementBack.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ndb.booksManagementBack.model.User;

@Mapper
public interface UserMapper {
	/**
	 * ユーザー情報を取得
	 * @return
	 */
	User getUser(User user);
}
