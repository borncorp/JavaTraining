package com.borncorp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import com.borncorp.models.DBConnection;
import com.borncorp.models.Post;
import com.sun.rowset.CachedRowSetImpl;

public class PostDAO extends DBConnection{

	public void createPost(Post post) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			PreparedStatement stmt = createStatement("INSERT INTO posts (username, content) VALUES (?,?)");
			
			stmt.setString(1, post.getUsername());
			stmt.setString(2, post.getContent());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public CachedRowSet getPost(Post post) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;

				try {
					PreparedStatement stmt = createStatement("SELECT * FROM posts WHERE postid = ? LIMIT 1");
					
					stmt.setInt(1, post.getPostid());
				    rs = stmt.executeQuery();
				    
				    results = new CachedRowSetImpl();
				    results.populate(rs);
				    stmt.close();
				    rs.close();
				}
				catch (SQLException ex){
				    // handle any errors
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());

				}
				return results;
	}	
	
	public ArrayList<Post> getPosts(int howmany) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				ArrayList<Post> allposts = new ArrayList<>();
				
			//Saves results in a CachedRowSet
				try {
					PreparedStatement stmt = createStatement("SELECT * FROM posts LIMIT ?");
					
					stmt.setInt(1, howmany);
				    rs = stmt.executeQuery();
				    
				    results = new CachedRowSetImpl();
				    results.populate(rs);
				    stmt.close();
				    rs.close();
				}

				catch (SQLException ex){
				    // handle any errors
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());

				}
			
			//Transfer from CachedRowSet to ArrayList

				try {
					while(results.next()){
						int postid = results.getInt("postid");
						String username = results.getString("username");
						String content = results.getString("content");
						Timestamp date = results.getTimestamp("date");
					
						Post aPost = new Post(postid, username, content, date);
						allposts.add(aPost);			
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return allposts;		
	}
	
	public void updatePost(Post post) {
		// SQL STUFF
		try {
			PreparedStatement stmt = createStatement("UPDATE posts SET content = ? WHERE postid = ? LIMIT 1");

			stmt.setString(1, post.getContent());
			stmt.setInt(2, post.getPostid());
		    stmt.executeQuery();
		    stmt.close();
		}
		
		catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public void deletePost(Post post) {
		// SQL STUFF
		
		try {
			PreparedStatement stmt = createStatement("DELETE FROM posts WHERE postid = ? LIMIT 1");

			stmt.setInt(1, post.getPostid());
		    stmt.execute();
		    stmt.close();
		}
		catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}	
}
