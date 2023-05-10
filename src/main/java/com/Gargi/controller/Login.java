package com.Gargi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.garvitrajput.model.Book;
import com.garvitrajput.services.BookService;
import com.garvitrajput.services.LoginService;

@Controller
public class Login {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	BookService bookService;

	@PostMapping("/Login")
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView();
	    HttpSession session = request.getSession();

	    // check if user is already logged in
	    if (session.getAttribute("username") != null) {
	        mv.setViewName("dashboard");
	        return mv;
	    }
	    else {
	    	 // get username and password
		    String uname = request.getParameter("username");
		    String pass = request.getParameter("password");

		    // check if user exists and password is correct
		    if (loginService.checkLogin(uname, pass)) {
		        session.setAttribute("username", uname);
		        List<Book> books = bookService.retrieveBooks();
		        session.setAttribute("books", books);
		        mv.setViewName("dashboard");
		    } else {
		        mv.setViewName("index");
		    }
		    return mv;
		}
	}
}