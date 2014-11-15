package com.borncorp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.borncorp.models.Comment;
import com.borncorp.models.DBConnection;

public class CommentDAO extends DBConnection{

	public void createComment(Comment comment) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			PreparedStatement stmt = createStatement("INSERT INTO comments (username, content, postid) VALUES (?,?,?)");
			
			stmt.setString(1, comment.getUsername());
			stmt.setString(2, comment.getContent());
			stmt.setInt(3, comment.getPosttid());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}	
}
