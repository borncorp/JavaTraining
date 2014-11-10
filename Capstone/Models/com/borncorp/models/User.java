package com.borncorp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	public void create(String email, String password) {
		
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
}
