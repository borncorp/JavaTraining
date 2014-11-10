package com.borncorp.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.borncorp.models.DBConnection;
import com.borncorp.models.Database;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String connection = "jdbc:mysql://23.95.38.197/db?user=test&password=test";
		String driver = "com.mysql.jdbc.Driver";
		String ip = "23.95.38.197";
		String database="mydb";
		String user="myuser";
		String password="password";
        String connection = "jdbc:mysql://" + ip + "/" + database + "?user="+ user + "&password=" + password;
		
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldnt Load Mysql Driver");
		}
		
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed");
			e.getCause();
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		Statement stmt = null;

		
	    try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement couldnt be created");
			e.getCause();
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	    // INSERT, UPDATE, or DELETE 
	    
	    try {
			stmt.execute("INSERT INTO users " + 
			"(username ,password) VALUES" + 
			"('"+ "totototo" + "',  '"+ "totototo" + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Mysql returned an error on the execution");
			e.getCause();
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}	
		
			// SQL STUFF
/*					Statement stmt= null;
					
					try {
						DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

						// Do something with the Connection
						
						try {
						    stmt = conn.createStatement();
						    // INSERT, UPDATE, or DELETE 
						    
						    stmt.execute("INSERT INTO users " + 
						    "(username ,password) VALUES" + 
						    "('"+ "totototo" + "',  '"+ "totototo" + "')");

						    stmt.close();
						}
						catch (SQLException ex){
						    // handle any errors
						    System.out.println("Error1");
						    System.out.println("SQLException: " + ex.getMessage());
						    System.out.println("SQLState: " + ex.getSQLState());
						    System.out.println("VendorError: " + ex.getErrorCode());
						    stmt.close();
						}			
						
						//end
					} catch (SQLException ex) {
						// handle any errors
					    System.out.println("Error2");
						System.out.println("SQLException: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("VendorError: " + ex.getErrorCode());
					}
				}	
*/



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
