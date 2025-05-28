package com.ndb.booksManagementBack.model;

public class BookWithPage extends Book {
	private Integer fromNum;
	private Integer pageSize;

	public BookWithPage() {
		super();
	}

	public BookWithPage(Integer fromNum, Integer pageSize) {
		super();
		this.fromNum = fromNum;
		this.pageSize = pageSize;
	}

	public Integer getFromNum() {
		return fromNum;
	}

	public void setFromNum(Integer fromNum) {
		this.fromNum = fromNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
