package com.ndb.booksManagementBack.service;

import org.springframework.transaction.annotation.Transactional;

import com.ndb.booksManagementBack.controller.Result;
import com.ndb.booksManagementBack.model.Book;
import com.ndb.booksManagementBack.model.BookUpdate;
import com.ndb.booksManagementBack.model.BookWithPage;

@Transactional
public interface BookService {
	/**
	 * 新規書籍登録
	 * @param book
	 * @return
	 */
	Result addBook(Book book);

	/**
	 * 書籍検索
	 * @param bookWithPage
	 * @return
	 */
	Result findBook(BookWithPage bookWithPage);

	/**
	 * 書籍タイトル検索
	 * @param title
	 * @return
	 */
	Result findTitles(String title);

	/**
	 * 書籍詳細検索
	 * @param id
	 * @return
	 */
	Result findById(Integer id);

	/**
	 * 書籍情報更新
	 * @param id
	 * @return
	 */
	Result updateById(BookUpdate bu);

	/**
	 * 書籍削除
	 * @param id
	 * @return
	 */
	Result deleteById(Integer id, Integer categoryId);
}
