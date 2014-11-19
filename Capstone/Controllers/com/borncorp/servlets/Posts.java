package com.borncorp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borncorp.dao.PostDAO;
import com.borncorp.models.Post;

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
	@Override
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
		
		int currentpage = 0;
		int pagenumber = 0;
		int howmany = 10;
		int offset = 0;
		

		
		if (request.getParameter("currentpage")!=null) {
			if (request.getParameter("pagenumber") != null) {
				pagenumber = Integer.parseInt(request.getParameter("pagenumber"));
				currentpage = Integer.parseInt(request.getParameter("currentpage"));
			}
		}
		
		offset = currentpage * howmany;
				
		if (pagenumber*howmany>offset){
			offset = pagenumber*howmany;			
		}
		
		ArrayList<Post> allposts = new PostDAO().getPosts(offset, howmany);
	
		request.setAttribute("currentpage", currentpage);
	    request.setAttribute("allposts", allposts);
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/posts.jsp");
	    rd.forward(request, response);
	}
}
