package com.borncorp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.borncorp.dao.UserDAO;
import com.borncorp.models.User;

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
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = Jsoup.clean(request.getParameter("username"), Whitelist.none()).toLowerCase();
		String password = Jsoup.clean(request.getParameter("password"), Whitelist.none());
		
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		
		int code = new UserDAO().doRegister(user);
		
		//Code 1 = Login succesful
		//Code -1 = User taken
		//Code -2 = Unknown error
		
		if (code>0){
			request.getSession().setAttribute("isloggedin", username);
			response.sendRedirect("./Posts");
		}

		if (code<0){
			request.getSession().setAttribute("isloggedin", null);
			if (code== -1){
				System.out.println("User exists, cant register");
				request.getRequestDispatcher("/usertaken.jsp").forward(request,
						response);
			}
			if (code== -2){
				System.out.println("Unknown error");
				response.sendRedirect("./Posts");
			}
		}
	}
}
