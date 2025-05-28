package com.ndb.booksManagementBack.model;

import java.util.Date;

public class Book {
	// 書籍ID
	private Integer id;

	// 書籍タイトル
	private String title;

	// カテゴリID（例：1=技術、2=ビジネスなど）
	private Integer category;

	// 書籍の概要・要約
	private String summary;

	// 著者名
	private String author;

	// ISBNコード
	private String isbn;

	// 出版社名
	private String publisher;

	// 出版日（例：2024-05-22）
	private Date publishDate;

	// 蔵書数（全体の冊数）
	private Integer count;

	// 現在貸出中の冊数
	private Integer countOnBorrowed;

	// 所在地ID（同じ本は同じ場所に保管される）
	private Integer location;

	// 作成日時
	private Date createdAt;

	// 更新日時
	private Date updatedAt;

	public Book() {
		super();
	}

	public Book(Integer id, String title, Integer category, String summary, String author, String isbn,
			String publisher, Date publishDate, Integer count, Integer countOnBorrowed, Integer location,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.summary = summary;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.count = count;
		this.countOnBorrowed = countOnBorrowed;
		this.location = location;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCountOnBorrowed() {
		return countOnBorrowed;
	}

	public void setCountOnBorrowed(Integer countOnBorrowed) {
		this.countOnBorrowed = countOnBorrowed;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
