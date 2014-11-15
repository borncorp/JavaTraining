package com.borncorp.models;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	private int commentid;
	private int posttid;
	private String username;
	private String content;
	private Date date;
	
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPosttid() {
		return posttid;
	}
	public void setPosttid(int posttid) {
		this.posttid = posttid;
	}	
}
