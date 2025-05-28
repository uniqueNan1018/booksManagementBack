package com.ndb.booksManagementBack.service;

import org.springframework.transaction.annotation.Transactional;

import com.ndb.booksManagementBack.controller.Result;

@Transactional
public interface CategoryService {
	/**
	 * 新規カテゴリ作成
	 * @param CategoryName
	 * @return
	 */
	Result createCategory(String CategoryName);

	/**
	 * カテゴリ名はすでに存在するチェック
	 * @param CategoryName
	 * @return
	 */
	Result duplicateCheck(String CategoryName);

	/**
	 * カテゴリリストを取得
	 * @return
	 */
	Result getCategories();

	/**
	 * カテゴリ削除
	 * @param id
	 * @return
	 */
	Result delCategoryById(Integer id);
}
