package com.borncorp.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	private int postid;
	private String username;
	private String content;
	private Timestamp date;

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

	public Post() {
	}

}
