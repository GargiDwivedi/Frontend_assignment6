package com.garvitrajput.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.garvitrajput.model.*;
import com.garvitrajput.services.*;

@Controller
public class EditBook {
	@Autowired
	Book book;
	@Autowired
	AuthorService authors;
	@Autowired
	BookService bookService;

	@PostMapping("/Edit") // for post method mapping
	public ModelAndView editBook(@RequestParam("author") int authoid, @RequestParam("bookcode") int bookcode,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String bookname = request.getParameter("bookname");

		Author author = authors.getAuthorById(authoid);
		book.setAuthor(author);
		String addedon = request.getParameter("addedOn");

		book.setDate(addedon);
		book.setAuthor(author);
		book.setId(bookcode);
		book.setName(bookname);

		mv.addObject("book", book);
		List<Author> Author = authors.retrieveAuthors();

		mv.addObject("Author", Author);
		mv.setViewName("EditBook");

		return mv;
	}

	@PostMapping("/EditBook") // for post method mapping
	public ModelAndView addBook(@RequestParam("author") int authoid, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String bookcode = request.getParameter("bookCode");
		int bookCode = Integer.parseInt(bookcode);
		String bookname = request.getParameter("bookName");

		String addedon = request.getParameter("addedOn");

		Author author = authors.getAuthorById(authoid);
		book.setAuthor(author);

		book.setDate(addedon);

		book.setId(bookCode);
		book.setName(bookname);

		bookService.saveBook(book, "PUT");
		HttpSession session = request.getSession();
		List<Book> books = bookService.retrieveBooks();
		session.setAttribute("books", books);
		mv.setViewName("dashboard");
		return mv;
	}
}
