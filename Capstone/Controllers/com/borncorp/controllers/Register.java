package com.borncorp.controllers;

import java.io.IOException;
import java.sql.ResultSet;
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
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = Jsoup.clean(request.getParameter("email"), Whitelist.none()).toLowerCase();
		String password = Jsoup.clean(request.getParameter("password"), Whitelist.none());
		
		CachedRowSet results = new DBConnection().getUser(email);
		
		// Checks if user already exists, if not it adds the user to the DB.
		try {
			if (results.first()) {
				System.out.println("User exists");
				request.getRequestDispatcher("/usertaken.jsp").forward(request,
						response);
			}
			else
			{
				System.out.println("User doesnt exist");
				new DBConnection().createUser(email, password);
				System.out.println("Logged in!");
				request.getSession().setAttribute("loggedInUser",email);
				
				
				request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,
						response);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
