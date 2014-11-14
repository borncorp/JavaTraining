package com.borncorp.models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;

import com.mysql.jdbc.Blob;
import com.sun.rowset.CachedRowSetImpl;

public class DBConnection {
	public void createUser(String username, String password) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			PreparedStatement stmt = createStatement("INSERT INTO users (username, password) VALUES (?,?)");
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			stmt.execute();
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
			PreparedStatement stmt = createStatement("INSERT INTO posts (username, content) VALUES (?,?)");
			
			stmt.setString(1, username);
			stmt.setString(2, content);
			
			stmt.execute();
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
			PreparedStatement stmt = createStatement("INSERT INTO comments (username, content, postid) VALUES (?,?,?)");
			
			stmt.setString(1, username);
			stmt.setString(2, content);
			stmt.setString(3, postid);
			
			stmt.execute();
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
					PreparedStatement stmt = createStatement("SELECT * FROM users WHERE username = ? LIMIT 1");
					
					stmt.setString(1, username);
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
	
	public CachedRowSet getPost(int postid) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;

				try {
					PreparedStatement stmt = createStatement("SELECT * FROM posts WHERE postid = ? LIMIT 1");
					
					stmt.setInt(1, postid);
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

	public CachedRowSet getPosts(int howmany) {
		// SQL STUFF
				CachedRowSet results = null;
				ResultSet rs = null;
				
				
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
				return results;
	}
	
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
	
	public void updatePost(int postid, String content) {
		// SQL STUFF
		try {
			PreparedStatement stmt = createStatement("UPDATE posts SET content = ? WHERE postid = ? LIMIT 1");

			stmt.setString(1, content);
			stmt.setInt(2, postid);
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
	

	private PreparedStatement createStatement(String query) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			conn = DriverManager
					.getConnection(Database.connection);
			stmt = conn.prepareStatement(query);
		return stmt;
	}

	public void deletePost(int postid) {
		// SQL STUFF
		
		try {
			PreparedStatement stmt = createStatement("DELETE FROM posts WHERE postid = ? LIMIT 1");

			stmt.setInt(1, postid);
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
	}
