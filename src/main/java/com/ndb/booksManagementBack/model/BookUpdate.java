package com.ndb.booksManagementBack.model;

public class BookUpdate extends Book {
	// 更新前のカテゴリID
	private Integer prevCategory;

	public Integer getPrevCategory() {
		return prevCategory;
	}

	public void setPrevCategory(Integer prevCategory) {
		this.prevCategory = prevCategory;
	}

}
