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
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Sanitizes input
		String username = Jsoup.clean(request.getParameter("username"), Whitelist.none()).toLowerCase();
		String password = Jsoup.clean(request.getParameter("password"), Whitelist.none());
		
		//Creates new user
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		
		int code = new UserDAO().doLogin(user);
		
		//Code 1 = Login succesful
		//Code 2 = Admin Logged in
		//Code -1 = Wrong password
		//Code -2 = User doesnt exist
		//Code -3 = Unknown error
		
		if (code>0){
				System.out.println("Logged in!");
				request.getSession().setAttribute("isloggedin", username);
			
			if (code==2){
				System.out.println("Admin Logged in!");
				request.getSession().setAttribute("isadmin", true);
			}
			response.sendRedirect("./Posts");
		}

		if (code<0){
			if (code== -1){
				System.out.println("Wrong password");
			}
			if (code== -2){
				System.out.println("User doesnt exist");
			}
			if (code== -3){
				System.out.println("Unknown error");
			}
				request.getSession().setAttribute("isLoggedIn", null);
				response.sendRedirect("./Posts");
		}
}
}

