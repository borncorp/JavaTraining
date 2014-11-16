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

		Post post = new Post();
		post.setPostid(Integer.parseInt(request.getParameter("postid")));
		
		new PostDAO().createPost(post);
		
		CachedRowSet results = new PostDAO().getPost(post);
		
		ArrayList<Post> myPost = new ArrayList<>();
		
		try {
			while(results.next()){
				int postid = results.getInt("postid");
				String username = results.getString("username");
				String content = results.getString("content");
				Timestamp date = results.getTimestamp("date");
			
				Post aPost = new Post();
				
				aPost.setContent(content);
				aPost.setUsername(username);
				aPost.setPostid(postid);
				aPost.setDate(date);
				
				myPost.add(aPost);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    request.setAttribute("myPost", myPost);
	    request.setAttribute("postid", myPost.get(0).getPostid());
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/WEB-INF/editpost.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = Jsoup.clean(request.getParameter("simple-editor"), Whitelist.basicWithImages());
		int postid = Integer.parseInt(request.getParameter("postid"));
		
		Post post = new Post();
		post.setPostid(postid);
		post.setContent(content);
		
		new PostDAO().updatePost(post);
		response.sendRedirect("./Posts");
	}

}
