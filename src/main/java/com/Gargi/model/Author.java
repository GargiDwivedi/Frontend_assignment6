package com.Gargi.model;

import org.springframework.stereotype.Component;

@Component
public class Author {

	private int authorid;

	private String authorname;

	private String authid = Integer.toString(authorid);

	public String getAuthid() {
		return authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorname=" + authorname + "]";
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
}