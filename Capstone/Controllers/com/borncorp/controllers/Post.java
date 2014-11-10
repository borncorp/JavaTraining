package com.borncorp.controllers;

import java.sql.Timestamp;

public class Post {
	
	int postid;
	String username;
	String content;
	Timestamp date;
	
public Post(int postid, String username, String content, Timestamp date) {
	// TODO Auto-generated constructor stub
	this.postid=postid;
	this.username=username;
	this.content=content;
	this.date=date;
}

}
