package com.ndb.booksManagementBack.service.Impl;

import java.util.ArrayList;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndb.booksManagementBack.controller.Code;
import com.ndb.booksManagementBack.controller.Result;
import com.ndb.booksManagementBack.mapper.BookMapper;
import com.ndb.booksManagementBack.mapper.CategoryMapper;
import com.ndb.booksManagementBack.model.Book;
import com.ndb.booksManagementBack.model.BookUpdate;
import com.ndb.booksManagementBack.model.BookWithPage;
import com.ndb.booksManagementBack.model.PaginationRes;
import com.ndb.booksManagementBack.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookMapper bookMapper;

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	@Transactional
	public Result addBook(Book book) {
		int res = bookMapper.createBook(book);
		if (res == 1) {
			// カテゴリ使用状態更新
			Integer categoryId = book.getCategory();
			int updateRows = categoryMapper.plusUseCount(categoryId);

			if (updateRows == 0) {
				throw new RuntimeException("カテゴリの使用状態を更新できませんでした。");
			}

			return new Result(Code.SAVE_OK, res);
		}
		return new Result(Code.SAVE_ERROR, "書籍登録はできませんでした。");
	}

	@Override
	public Result findBook(BookWithPage bookWithPage) {
		ArrayList<Book> bookList = bookMapper.find(bookWithPage);
		int cnt = bookMapper.countBooks(bookWithPage);
		PaginationRes<Book> data = new PaginationRes<Book>();
		data.setList(bookList);
		data.setTotalCount(cnt);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result findTitles(String title) {
		ArrayList<String> bookTitles = bookMapper.findBookTitles(title);
		return new Result(Code.GET_OK, bookTitles);
	}

	@Override
	public Result findById(Integer id) {
		Book book = bookMapper.findById(id);
		return new Result(Code.GET_OK, book);
	}

	@Override
	@Transactional
	public Result updateById(BookUpdate bu) {
		int updateRows = bookMapper.updateById(bu);
		if (updateRows == 0) {
			LOGGER.error("書籍情報更新エラー" + bu.getId());
			throw new RuntimeException("書籍情報更新できませんでした。");
		}

		Integer categoryId = bu.getCategory();
		Integer prevCategoryId = bu.getPrevCategory();
		if (!Objects.equals(categoryId, prevCategoryId)) {
			int categoryUpdateRow1 = categoryMapper.plusUseCount(categoryId);
			if (categoryUpdateRow1 == 0) {
				throw new RuntimeException("カテゴリ1の使用状態を更新できませんでした。");
			}
			int categoryUpdateRow2 = categoryMapper.minusUseCount(prevCategoryId);
			LOGGER.info("prevCategoryId=" + prevCategoryId);
			if (categoryUpdateRow2 == 0) {
				throw new RuntimeException("カテゴリ2の使用状態を更新できませんでした。");
			}
		}

		return new Result(Code.UPDATE_OK, updateRows);
	}

	@Override
	@Transactional
	public Result deleteById(Integer id, Integer categoryId) {
		// 関連カテゴリID更新
		int categoryUpdateRow = categoryMapper.minusUseCount(categoryId);
		if (categoryUpdateRow == 0) {
			LOGGER.error("カテゴリの使用状態更新エラー" + categoryId);
			throw new RuntimeException("カテゴリの使用状態を更新できませんでした。");
		}
		int res = bookMapper.deleteById(id);
		if (res == 0) {
			LOGGER.error("書籍削除エラー" + id);
			throw new RuntimeException("書籍削除できませんでした。");
		}
		return new Result(Code.DELETE_OK, res);
	}

}
