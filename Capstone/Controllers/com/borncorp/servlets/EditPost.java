package com.borncorp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.borncorp.dao.PostDAO;
import com.borncorp.models.DBConnection;
import com.borncorp.models.Post;

/**
 * Servlet implementation class EditPost
 */
@WebServlet("/EditPost")
public class EditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean isadmin=(boolean) request.getSession().getAttribute("isadmin");
		
		if (isadmin != true) {
			response.sendRedirect("./Posts");
		}
		else{
		Post post = new Post();
		post.setPostid(Integer.parseInt(request.getParameter("postid")));
		
		post = new PostDAO().getPost(post);
		
		
	    request.setAttribute("post", post);
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/WEB-INF/editpost.jsp");
	    rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isadmin=(boolean) request.getSession().getAttribute("isadmin");
		
		if (isadmin != true) {
			response.sendRedirect("./Posts");
		}
		else {
		String title = Jsoup.clean(request.getParameter("title"), Whitelist.basicWithImages());
		String content = Jsoup.clean(request.getParameter("simple-editor"), Whitelist.none());
		int postid = Integer.parseInt(request.getParameter("postid"));
		
		Post post = new Post();
		post.setPostid(postid);
		post.setTitle(title);
		post.setContent(content);
		
		new PostDAO().updatePost(post);
		response.sendRedirect("./Posts");
		}
	}

}
