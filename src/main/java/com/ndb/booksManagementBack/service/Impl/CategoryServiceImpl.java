package com.ndb.booksManagementBack.service.Impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndb.booksManagementBack.controller.Code;
import com.ndb.booksManagementBack.controller.Result;
import com.ndb.booksManagementBack.mapper.CategoryMapper;
import com.ndb.booksManagementBack.model.Category;
import com.ndb.booksManagementBack.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public Result createCategory(String CategoryName) {
		int res = categoryMapper.createCategory(CategoryName);
		if (res == 1) {
			LOGGER.info(CategoryName + "新規作成");
			return new Result(Code.SAVE_OK, null);
		}
		return new Result(Code.SYSTEM_ERROR, null, "カテゴリの作成はできませんでした。");
	}

	@Override
	public Result duplicateCheck(String CategoryName) {
		LOGGER.info(CategoryName + "新規作成チェック");
		int res = categoryMapper.getCategoryCntByName(CategoryName);
		return new Result(Code.GET_OK, res);
	}

	@Override
	public Result getCategories() {
		LOGGER.info("カテゴリ取得");
		ArrayList<Category> data = categoryMapper.getAllCategories();
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result delCategoryById(Integer id) {
		LOGGER.info("カテゴリ削除");
		int res = categoryMapper.deleteById(id);
		return new Result(Code.DELETE_OK, res);
	}

}
