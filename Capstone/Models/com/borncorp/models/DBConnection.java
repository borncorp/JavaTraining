package com.borncorp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DBConnection {
	
	public CachedRowSet getSettings() {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				try {
					PreparedStatement stmt = createStatement("SELECT * FROM settings");
					
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
	

	protected PreparedStatement createStatement(String query) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			conn = DriverManager
					.getConnection(Database.connection);
			stmt = conn.prepareStatement(query);
		return stmt;
	}
}