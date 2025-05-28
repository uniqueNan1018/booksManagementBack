package com.ndb.booksManagementBack.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ndb.booksManagementBack.model.Book;
import com.ndb.booksManagementBack.model.BookUpdate;
import com.ndb.booksManagementBack.model.BookWithPage;

@Mapper
public interface BookMapper {
	/**
	 * 新規書籍登録
	 * @param book
	 * @return
	 */
	Integer createBook(Book book);

	/**
	 * 書籍検索
	 * @param bookWithPage
	 * @return
	 */
	ArrayList<Book> find(BookWithPage bookWithPage);

	/**
	 * 書籍検索結果数
	 * @param bookWithPage
	 * @return
	 */
	Integer countBooks(BookWithPage bookWithPage);

	/**
	 * 書籍タイトル検索
	 * @param title
	 * @return
	 */
	ArrayList<String> findBookTitles(String title);

	/**
	 * 書籍情報
	 * @param id
	 * @return
	 */
	Book findById(Integer id);

	/**
	 * 書籍情報更新
	 * @param id
	 * @return
	 */
	Integer updateById(BookUpdate bu);

	/**
	 * 書籍削除
	 * @param id
	 * @return
	 */
	Integer deleteById(Integer id);
}
