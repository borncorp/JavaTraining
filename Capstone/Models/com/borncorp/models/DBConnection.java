package com.borncorp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DBConnection {
	public void createUser(String email, String password) {
		// SQL STUFF
				Connection conn = null;
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					conn = DriverManager
							.getConnection(Database.connection);

					// Do something with the Connection
					
					Statement stmt = null;
					
					try {
					    stmt = conn.createStatement();
					    // INSERT, UPDATE, or DELETE 
					    
					    stmt.execute("INSERT INTO users " + 
					    "(username ,password) VALUES" + 
					    "('"+ email + "',  '"+ password + "')");

					    stmt.close();
					}
					catch (SQLException ex){
					    // handle any errors
					    System.out.println("SQLException: " + ex.getMessage());
					    System.out.println("SQLState: " + ex.getSQLState());
					    System.out.println("VendorError: " + ex.getErrorCode());
					    stmt.close();
					}			
					
					//end
				} catch (SQLException ex) {
					// handle any errors
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());
				}
			}	

	public void createPost(String email, String content) {
		// SQL STUFF
				Connection conn = null;
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					conn = DriverManager
							.getConnection(Database.connection);

					// Do something with the Connection
					
					Statement stmt = null;
					
					try {
					    stmt = conn.createStatement();
					    // INSERT, UPDATE, or DELETE 
					    stmt.execute("INSERT INTO posts " + 
					    "(username ,content) VALUES" + 
					    "('"+ email + "',  '"+ content + "')");
					    // Now do something with the ResultSet ....
					    stmt.close();
					}
					catch (SQLException ex){
					    // handle any errors
					    System.out.println("SQLException: " + ex.getMessage());
					    System.out.println("SQLState: " + ex.getSQLState());
					    System.out.println("VendorError: " + ex.getErrorCode());
					    stmt.close();
					}			
					
					//end
				} catch (SQLException ex) {
					// handle any errors
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());
				}
			}	

	public void createComment(String email, String content, String postid) {
		// SQL STUFF
				Connection conn = null;
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					conn = DriverManager
							.getConnection(Database.connection);

					// Do something with the Connection
					
					Statement stmt = null;
					
					try {
					    stmt = conn.createStatement();
					    // INSERT, UPDATE, or DELETE 
					    stmt.execute("INSERT INTO comments " + 
					    "(username ,content, postid) VALUES" + 
					    "('"+ email + "',  '"+ content + "',  '" + postid + "')");
					    // Now do something with the ResultSet ....
					    stmt.close();
					}
					catch (SQLException ex){
					    // handle any errors
					    System.out.println("SQLException: " + ex.getMessage());
					    System.out.println("SQLState: " + ex.getSQLState());
					    System.out.println("VendorError: " + ex.getErrorCode());
					    stmt.close();
					}			
					
					//end
				} catch (SQLException ex) {
					// handle any errors
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());
				}
			}	

	public CachedRowSet getUser(String email) {
		// SQL STUFF
				Connection conn = null;
				CachedRowSet results = null;
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					conn = DriverManager
							.getConnection(Database.connection);

					// Do something with the Connection
					
					Statement stmt = null;
					ResultSet rs = null;
					
					try {
					    stmt = conn.createStatement();
					    // INSERT, UPDATE, or DELETE 
					    
					    rs = stmt.executeQuery("SELECT * FROM users WHERE username = " + "'" + email + "'");
					    
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
					    stmt.close();
					    rs.close();
					}			
					
					//end
				} catch (SQLException ex) {
					// handle any errors
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState: " + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());
				}
				return results;
			}
}

