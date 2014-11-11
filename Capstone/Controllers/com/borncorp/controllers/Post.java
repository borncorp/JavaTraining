package com.borncorp.controllers;

import java.sql.Timestamp;

public class Post {

	int postid;
	String username;
	String content;
	Timestamp date;

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Post(int postid, String username, String content, Timestamp date) {
		// TODO Auto-generated constructor stub
		this.postid = postid;
		this.username = username;
		this.content = content;
		this.date = date;
	}

}
