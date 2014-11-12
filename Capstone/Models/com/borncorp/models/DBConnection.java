package com.borncorp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DBConnection {
	public void createUser(String username, String password) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			Statement stmt = createStatement();

			stmt.execute("INSERT INTO users " + "(username ,password) VALUES"
					+ "('" + username + "',  '" + password + "')");

			stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public void createPost(String username, String content) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			Statement stmt = createStatement();

		    stmt.execute("INSERT INTO posts " + 
		    "(username ,content) VALUES" + 
		    "('"+ username + "',  '"+ content + "')");

			stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public void createComment(String username, String content, String postid) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			Statement stmt = createStatement();

		    stmt.execute("INSERT INTO comments " + 
		    "(username ,content, postid) VALUES" + 
		    "('"+ username + "',  '"+ content + "',  '" + postid + "')");
		    // Now do something with the ResultSet ....
		    stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public CachedRowSet getUser(String username) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				try {
				    // INSERT, UPDATE, or DELETE 
				    Statement stmt = createStatement();
				    rs = stmt.executeQuery("SELECT * FROM users WHERE username = " + "'" + username + "'");
				    
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
	
	public CachedRowSet getPost(int postid) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				try {
				    // INSERT, UPDATE, or DELETE 
				    Statement stmt = createStatement();
				    rs = stmt.executeQuery("SELECT * FROM posts WHERE postid=" + postid);
				    
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

	public CachedRowSet getPosts(int howmany) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				try {
				    // INSERT, UPDATE, or DELETE 
				    Statement stmt = createStatement();
				    rs = stmt.executeQuery("SELECT * FROM posts LIMIT 0 , " + howmany);
				    
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
	
	public CachedRowSet getSettings() {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				try {
				    // INSERT, UPDATE, or DELETE 
				    Statement stmt = createStatement();
				    rs = stmt.executeQuery("SELECT * FROM settings");
				    
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
	
	public void updatePost(int postid, String content) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			Statement stmt = createStatement();

		    stmt.execute("UPDATE posts SET content ='" + content + "' WHERE postid=" + postid + " LIMIT 1");
			stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	

	private Statement createStatement() throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			conn = DriverManager
					.getConnection(Database.connection);
			stmt = conn.createStatement();

		return stmt;
	}
}
