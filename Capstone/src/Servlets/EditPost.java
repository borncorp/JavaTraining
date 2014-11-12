package Servlets;

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

import com.borncorp.controllers.Post;
import com.borncorp.models.DBConnection;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		CachedRowSet results = new DBConnection().getPost(Integer.parseInt(request.getParameter("postid")));
		
		ArrayList<Post> myPost = new ArrayList<>();
		
		try {
			while(results.next()){
				int postid = results.getInt("postid");
				String username = results.getString("username");
				String content = results.getString("content");
				Timestamp date = results.getTimestamp("date");
			
				Post aPost = new Post(postid, username, content, date);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = Jsoup.clean(request.getParameter("simple-editor"), Whitelist.basicWithImages());
		int postid = Integer.parseInt(request.getParameter("postid"));
		
		new DBConnection().updatePost(postid, content);
		response.sendRedirect("./Posts");
	}

}
