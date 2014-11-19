package com.borncorp.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;

import com.borncorp.models.DBConnection;
import com.borncorp.models.User;
import com.sun.rowset.CachedRowSetImpl;

public class UserDAO extends DBConnection{

	private void createUser(User user) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			PreparedStatement stmt = createStatement("INSERT INTO users (username, password) VALUES (?,?)");
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	

	public CachedRowSet getUser(User user) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				try {
					PreparedStatement stmt = createStatement("SELECT * FROM users WHERE username = ? LIMIT 1");
					
					stmt.setString(1, user.getUsername());
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
	

	public void uploadAvatar(String username, BufferedImage avatarthumb) {

		try {
			PreparedStatement stmt = createStatement("UPDATE users SET avatar = ? WHERE username = ? LIMIT 1");

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ImageIO.write(avatarthumb, "png", baos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] bytes = baos.toByteArray();
			
			
			stmt.setBytes(1, bytes);
			stmt.setString(2, username);
		    stmt.executeUpdate();
		    stmt.close();
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
        } 
    }
	
	public int doLogin (User user){
	
		//Retrieves user from Database
		CachedRowSet results = getUser(user);
		
	try {
		if (results.first()) {
			//User exists
			if (user.getUsername().equals(results.getString("username"))
					&&
				user.getPassword().equals(results.getString("password"))) {
				
				if(results.getBoolean("isadmin")==true){
					return 2; //Admin logged in
				}
				return 1; //Logged in
			
			} else {
				return -1; // Wrong password
			}
		}
		else
		{
			return -2; //User doesnt exist
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return -3; //Unknown error
}
	
	public int doRegister(User user){
			
		CachedRowSet results = new UserDAO().getUser(user);
		
		// Checks if user already exists, if not it adds the user to the DB.
		try {
			if (results.first()) {
				return -1;  //User exists, cant register
			}
			else
			{   //User doesnt exist
				createUser(user);
				return 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return -2;
	}
}
