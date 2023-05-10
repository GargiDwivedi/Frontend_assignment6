package com.Gargi.model;


import org.springframework.stereotype.Component;

@Component
public class Book {

	private int id;

	private String name;
	private Author author;
	private String date;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author authorid) {
		this.author = authorid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", date=" + date + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, Author author, String date) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.date = date;
	}

	
}
