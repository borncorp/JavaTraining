package com.borncorp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.borncorp.models.DBConnection;

/**
 * Servlet implementation class PostsController
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = Jsoup.clean(request.getParameter("email"),
				Whitelist.none());
		String password = Jsoup.clean(request.getParameter("password"),
				Whitelist.none());

		if (email.equals("born@gmail.com") && password.equals("B12345678")) {
			request.getRequestDispatcher("/WEB-INF/done.jsp").forward(request,
					response);
			System.out.println("Logged in!");
			request.getSession().setAttribute("loggedInUser",
					"bornmail@gmail.com");
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			System.out.println("Wrong!");
			System.out.println(email);
			System.out.println(password);
		}
// SQL STUFF
		new DBConnection().createUser("test@gmail.com", "mypassword");
//
//		Connection conn = null;
//		try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
//			conn = DriverManager
//					.getConnection("jdbc:mysql://23.95.38.197/db?"
//							+ "user=test&password=test");
//
//			// Do something with the Connection
//			
//			Statement stmt = null;
//			
//			try {
//			    stmt = conn.createStatement();
//			    stmt.execute("UPDATE users SET password='5654' WHERE username='borncorp'");
//
//			    // Now do something with the ResultSet ....
//			}
//			catch (SQLException ex){
//			    // handle any errors
//			    System.out.println("SQLException: " + ex.getMessage());
//			    System.out.println("SQLState: " + ex.getSQLState());
//			    System.out.println("VendorError: " + ex.getErrorCode());
//			}			
//			
//			//end
//		} catch (SQLException ex) {
//			// handle any errors
//			System.out.println("SQLException: " + ex.getMessage());
//			System.out.println("SQLState: " + ex.getSQLState());
//			System.out.println("VendorError: " + ex.getErrorCode());
//		}
//	}
}
}
