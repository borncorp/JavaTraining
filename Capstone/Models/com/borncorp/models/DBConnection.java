package com.borncorp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public void createUser(String email, String password) {
		// SQL STUFF
				Connection conn = null;
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					conn = DriverManager
							.getConnection("jdbc:mysql://23.95.38.197/db?"
									+ "user=test&password=test");

					// Do something with the Connection
					
					Statement stmt = null;
					
					try {
					    stmt = conn.createStatement();
					    // INSERT, UPDATE, or DELETE 
					    stmt.execute("INSERT INTO users " + 
					    "(username ,password) VALUES" + 
					    "('"+ email + "',  '"+ password + "')");
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

	public void createPost(String email, String content) {
		// SQL STUFF
				Connection conn = null;
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					conn = DriverManager
							.getConnection("jdbc:mysql://23.95.38.197/db?"
									+ "user=test&password=test");

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
							.getConnection("jdbc:mysql://23.95.38.197/db?"
									+ "user=test&password=test");

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

}

