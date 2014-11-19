package com.borncorp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.borncorp.dao.PostDAO;
import com.borncorp.models.Post;

/**
 * Servlet implementation class NewPost
 */
@WebServlet("/NewPost")
public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/newpost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = Jsoup.clean(request.getParameter("title"), Whitelist.none());
		String content = Jsoup.clean(request.getParameter("simple-editor"), Whitelist.basicWithImages());
		String username = request.getSession().getAttribute("isloggedin").toString();
		
		Post post = new Post();
		post.setUsername(username);
		post.setContent(content);
		post.setTitle(title);
		
		new PostDAO().createPost(post);
		response.sendRedirect("./Posts");
	}

}
