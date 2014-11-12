package com.borncorp.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

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
		String username = Jsoup.clean(request.getParameter("username"), Whitelist.none()).toLowerCase();
		String password = Jsoup.clean(request.getParameter("password"), Whitelist.none());
		
		CachedRowSet results = new DBConnection().getUser(username);

		try {
				if (results.first()) {
					System.out.println("User exists");

					if (username.equals(results.getString("username")) && password.equals(results.getString("password"))) {
						System.out.println("Logged in!");
						request.getSession().setAttribute("isLoggedIn", username);
						if(results.getBoolean("isadmin")==true){
							request.getSession().setAttribute("isadmin", true);
						}
						request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,
								response);	
					
					} else {

						System.out.println("Wrong!");
						request.getSession().setAttribute("isLoggedIn", null);
						request.getRequestDispatcher("/index.jsp").forward(request,
								response);
					}
				}
				else
				{
					System.out.println("User doesnt exist");

					
					request.getRequestDispatcher("/register.jsp").forward(request,
							response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}


