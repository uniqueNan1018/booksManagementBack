package com.ndb.booksManagementBack.model;

public class Category {
	// カテゴリID
	private Integer id;
	//　カテゴリ名
	private String categoryName;
	// 使用状態
	private Integer useCount;

	public Category() {
		super();
	}

	public Category(Integer id, String categoryName, Integer useCount) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.useCount = useCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getUseCount() {
		return useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

}
