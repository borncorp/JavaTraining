package com.borncorp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;

import com.borncorp.models.DBConnection;

/**
 * Servlet implementation class Posts
 */
@WebServlet("/Posts")
public class Posts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Posts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		CachedRowSet test= new DBConnection().getSettings();
//	    int tester=13;
//		try {
//			tester = test.getInt("postsperpage");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(tester);
		CachedRowSet posts= new DBConnection().getPosts(10);
		
		ArrayList<Post> allposts = new ArrayList<>();
		
		try {
			while(posts.next()){
				int postid = posts.getInt("postid");
				String username = posts.getString("username");
				String content = posts.getString("content");
				Timestamp date = posts.getTimestamp("date");
			
				Post aPost = new Post(postid, username, content, date);
				allposts.add(aPost);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    request.setAttribute("allposts", allposts);
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/WEB-INF/posts.jsp");
	    rd.forward(request, response);
	}
}
