package com.ndb.booksManagementBack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndb.booksManagementBack.model.Category;
import com.ndb.booksManagementBack.service.CategoryService;

@RestController
@RequestMapping("/logged/category")
public class CategoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@GetMapping("/cnt/{categoryName}")
	Result getCnt(@PathVariable String categoryName) {
		return categoryService.duplicateCheck(categoryName);
	}

	@PostMapping()
	Result create(@RequestBody Category c) {
		String categoryName = c.getCategoryName();
		return categoryService.createCategory(categoryName);
	}

	@GetMapping()
	Result getAll() {
		return categoryService.getCategories();
	}

	@DeleteMapping("/{id}")
	Result deleteById(@PathVariable Integer id) {
		return categoryService.delCategoryById(id);
	}
}
