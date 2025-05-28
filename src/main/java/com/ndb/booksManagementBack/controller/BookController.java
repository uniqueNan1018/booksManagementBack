package com.ndb.booksManagementBack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndb.booksManagementBack.model.Book;
import com.ndb.booksManagementBack.model.BookUpdate;
import com.ndb.booksManagementBack.model.BookWithPage;
import com.ndb.booksManagementBack.service.BookService;

@RestController
@RequestMapping("/logged/book")
public class BookController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@PostMapping()
	Result createBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PostMapping("/search")
	Result searchBooks(@RequestBody BookWithPage bookWithPage) {
		return bookService.findBook(bookWithPage);
	}

	@GetMapping("/titles/{title}")
	Result findTitles(@PathVariable String title) {
		return bookService.findTitles(title);
	}

	@GetMapping("/{id}")
	Result findById(@PathVariable Integer id) {
		LOGGER.info("書籍id: " + id);
		return bookService.findById(id);
	}

	@PutMapping("/{id}")
	Result updateById(@RequestBody BookUpdate bu) {
		LOGGER.info("書籍id: " + bu.getId());
		return bookService.updateById(bu);
	}

	@DeleteMapping("/bookId/{id}/cteId/{cteId}")
	Result delById(@PathVariable("id") Integer id,
			@PathVariable("cteId") Integer cteId) {
		return bookService.deleteById(id, cteId);
	}
}
