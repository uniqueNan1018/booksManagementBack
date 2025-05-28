package com.ndb.booksManagementBack.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ndb.booksManagementBack.model.Category;

@Mapper
public interface CategoryMapper {
	/**
	 * カテゴリ追加
	 * @param categoryName
	 * @return　１は成功　０は失敗
	 */
	Integer createCategory(String categoryName);

	/**
	 * カテゴリ存在するチェック
	 * @param categoryName
	 * @return 0は存在なし、１は存在あり
	 */
	Integer getCategoryCntByName(String categoryName);

	/**
	 * カテゴリリスト取得
	 * @return
	 */
	ArrayList<Category> getAllCategories();

	/**
	 * カテゴリの削除
	 * @param id
	 * @return
	 */
	Integer deleteById(Integer id);

	/**
	 * 使用カウントプラス１
	 * @param category
	 * @return
	 */
	Integer plusUseCount(Integer id);

	/**
	 * 使用カウントマイナス１
	 * @param category
	 * @return
	 */
	Integer minusUseCount(Integer id);
}
