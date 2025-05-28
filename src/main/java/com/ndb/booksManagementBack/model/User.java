package com.ndb.booksManagementBack.model;

public class User {
	// ユーザーID
	private String userId;
	// ユーザー名
	private String username;
	// パスワード
	private String password;
	// ユーザー区分
	private Integer role;

	public User() {
		super();
	}

	public User(String userId, String username, String password, Integer role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
